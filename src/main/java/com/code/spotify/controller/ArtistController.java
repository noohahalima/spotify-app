package com.code.spotify.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.code.spotify.entity.Artists;
import com.code.spotify.entity.Songs;
import com.code.spotify.service.ArtistsService;
import com.code.spotify.service.SongsService;

@Controller
//requestmapping for the controller
@RequestMapping("/artists")
public class ArtistController {
	@Autowired
	private ArtistsService artistsservice;
	@Autowired
    ServletContext servletContext;
	

@RequestMapping("showform")
public String showForm(Model model)
{
	//create the object of the songs class
	Artists artists=new Artists();
	//create add the songs to the model 
	model.addAttribute("artists",artists);
	return "artists-form";
}

@RequestMapping(value="artistsform",method=RequestMethod.POST)
public String songsForm(@ModelAttribute("artists") Artists artists)
{
	//we check the value
	//if it is null or 0 we will add the record else
	//update the record
	//call the service method to add  and pass the  object
	//print the value of the id
	System.out.println("name"+artists.getArtistname());
//	if(songs.getSongname()>0)
//	{
//		songsservice.update(songs);
//	}
//	else
//	{
//	songsservice.add(songs);
//	}
	artistsservice.add(artists);
	
	return "artists-list";
}

@RequestMapping("list")
public String list(Model model)
{
	//get the list of the students from the service
	List<Artists> artists=	artistsservice.getAll();
	//we add the studentlist to the model
	model.addAttribute("artists",artists);
	//retunr the view
	return "artistslist";
}
@RequestMapping("deleteartists/{id}")
//{id} we can get this by using @pathvariable to get the value from the url
public String deleteartists(@PathVariable int id,Model model)
{
	System.out.println(id);

	artistsservice.delete(id);
	return "redirect://artists/list";
}


@RequestMapping(value="save",method=RequestMethod.POST)
public ModelAndView SaveSongs(@Valid @ModelAttribute("artists") Artists artists  ,Model model,
		HttpServletRequest request,BindingResult result)
{
if(result.hasErrors())
{
	System.out.println("error");
	List<Artists>	artist=artistsservice.getAll();
	Map<String, Object> modell = new HashMap<String, Object>();
	
	modell.put("artistslist",  artist);

	return new ModelAndView("artists-form",modell);
}
else
{
	artistsservice.add(artists);
return new ModelAndView("redirect:/artists/list");
}
}
}
