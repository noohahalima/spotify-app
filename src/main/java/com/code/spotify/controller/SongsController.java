package com.code.spotify.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.code.spotify.entity.Artists;
import com.code.spotify.entity.Songs;
import com.code.spotify.service.ArtistsService;
import com.code.spotify.service.SongsService;






@Controller
//requestmapping for the controller
@RequestMapping("/songs")
	
	public class SongsController {
	//inject the songsService
		@Autowired
		private SongsService songsservice;
		@Autowired
		private ArtistsService artistsservice;
		@Autowired
	    ServletContext servletContext;
		
		@RequestMapping("showform")
		public ModelAndView list()
		{
			//get the list of the artists
			List<Artists> artists=	artistsservice.getAll();
			Map<String, Object> model = new HashMap<String, Object>();
			
			model.put("artistlist", artists);
			model.put("songs", new Songs());
			return new ModelAndView("songs-form",model);
		}



@RequestMapping(value="songsform",method=RequestMethod.POST)
public String songsForm(@ModelAttribute("songs") Songs songs)
{
	//we check the value
	//if it is null or 0 we will add the record else
	//update the record
	//call the service method to add  and pass the  object
	//print the value of the id
	System.out.println("name"+songs.getSongname());
//	if(songs.getSongname()>0)
//	{
//		songsservice.update(songs);
//	}
//	else
//	{
//	songsservice.add(songs);
//	}
	songsservice.add(songs);
	
	return "confirmation";
}

//create a controller return the list of songs
//requestmapping
@RequestMapping("list")
public String list(Model model)
{
	//get the list of the students from the service
	List<Songs> songs=	songsservice.getAll();
	//we add the songslist to the model
	model.addAttribute("songs",songs);
	//retunr the view
	return "songslist";
}




//requestmapping for edit
@RequestMapping("editsongs/{id}")
//{id} we can get this by using @pathvariable to get the value from the url
public ModelAndView editSongs(@PathVariable("id") int songname)
{
	//we get the songs information from the service for the id
	Songs songs=songsservice.getById(songname);
	
	Map<String, Object> model = new HashMap<String, Object>();
	//add the  object to the model
	model.put("songs", songs);
	//retunr the view
	return new ModelAndView("songs-form",model);
}
@RequestMapping("deletesongs/{id}")
//{id} we can get this by using @pathvariable to get the value from the url
public String deletesongs(@PathVariable int id,Model model)
{
	System.out.println(id);

	songsservice.delete(id);
	return "redirect://songs/list";
}


@RequestMapping(value="save",method=RequestMethod.POST)
public ModelAndView SaveSong(@Valid @ModelAttribute("product") Songs songs  ,Model model,
		HttpServletRequest request,BindingResult result) throws Exception
{
	if(result.hasErrors())
	{
		System.out.println("error");
	}
	
	System.out.println("song file name is "+request.getParameter("filename"));
	songs.setFilename(request.getParameter("filename"));
	System.out.println("The song name sent is "+request.getParameter("songs"));
	
	try {
        if (songs.getFilename().trim() != "" || songs.getFilename() != null) {
            File directory;
            String check = File.separator; // Checking if system is linux
                                            // based or windows based by
                                            // checking seprator used.
            String path = null;
            if (check.equalsIgnoreCase("\\")) {
                path = servletContext.getRealPath("").replace("build\\", ""); // gives real path as /build/web/
                                                                              // so we need to replace build in the path
                                                                                    }
            //in case of MAC
            if (check.equalsIgnoreCase("/")) {
                path = servletContext.getRealPath("").replace("build/", "");
                path += "/"; // Adding trailing slash for Mac systems.
            }
            //creating the director path
            directory = new File(path + "\\" + songs.getFilename());
            //checking the directory exits
            boolean temp = directory.exists();
            if (!temp) {
            	//create the new director if the director not exits
                temp = directory.mkdir();
            }
            if (temp) {
                // We need to transfer to a file
                CommonsMultipartFile photoInMemory = songs.getPhoto();

                String fileName = photoInMemory.getOriginalFilename();
                // could generate file names as well
                //creating the file with the path to create and store the file
                File localFile = new File(directory.getPath(), fileName);

                // move the file from memory to the file

                photoInMemory.transferTo(localFile);
               songs.setFilename(localFile.getPath());
                System.out.println("File is stored at" + localFile.getPath());
                System.out.print("registern");
                
               // if(songs.getSongid()==null)
                	//songs.setItemId(0);
                if(songs.getSongid()==0)
                songsservice.add(songs);
                else
                songsservice.update(songs);
                return new ModelAndView("redirect:/songs/list");
            
            } else {
                System.out.println("Failed to create directory!");
                return new ModelAndView("error", "errorMessage", "error while creating directory");
            }

        
        }

    } catch (IllegalStateException e) {
        System.out.println("*** IllegalStateException: " + e.getMessage());
        return new ModelAndView("error", "errorMessage", "error while creating directory");
    } catch (IOException e) {
        // TODO Auto-generated catch block
        System.out.println("*** IOException: " + e.getMessage());
        return new ModelAndView("error", "errorMessage", "error while creating directory");
    }

	return new ModelAndView("error", "errorMessage", "error while creating directory");

}

@RequestMapping(value="saves",method=RequestMethod.POST)
public ModelAndView SaveSongs(@Valid @ModelAttribute("product") Songs songs  ,Model model,
		HttpServletRequest request,BindingResult result)
{
if(result.hasErrors())
{
	System.out.println("error");
	List<Songs>	songss=songsservice.getAll();
	Map<String, Object> modell = new HashMap<String, Object>();
	
	modell.put("songslist",  songs);

	return new ModelAndView("songs-form",modell);
}
else
{
	songsservice.add(songs);
return new ModelAndView("redirect:/songs/list");
}
}
}



