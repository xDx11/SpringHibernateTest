package cz.spring.tutorial.controller;

import cz.spring.tutorial.model.Cachelog;
import cz.spring.tutorial.model.Geocache;
import cz.spring.tutorial.model.Geotest;
import cz.spring.tutorial.model.Player;
import cz.spring.tutorial.service.CachelogService;
import cz.spring.tutorial.service.GeoService;
import cz.spring.tutorial.service.GeocacheService;
import cz.spring.tutorial.service.PlayerService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

	//@Autowired
	//private GeoService geoService;
        
        @Autowired
        private GeocacheService geocacheService;
        
        @Autowired
        private PlayerService playerService;
        
        @Autowired
        private CachelogService cachelogSevice;
	
        @RequestMapping("/")
	public ModelAndView base() {
            ModelAndView model = new ModelAndView("home");
            System.out.println("TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEST_____________________BASE");            
            return model;
	}
	
	@RequestMapping("/home")
	public ModelAndView home() {
            ModelAndView model = new ModelAndView("home");
            System.out.println("TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEST_____________________");   
            //Geotest geo = geoService.getGeoObject(1);
            //System.out.println(geo.getId());
            //System.out.println(geo.getTitle());
            //System.out.println(geo.getAuthor());
            Geocache geocache = geocacheService.getGeoObject(1);
            System.out.println(geocache.getId());
            System.out.println(geocache.getName());
            System.out.println(geocache.getCode());
            System.out.println("----------");
            List<Geocache> caches = geocacheService.getGeoList();
            for(Geocache item : caches){
                System.out.println(item.getId());
                System.out.println(item.getName());
                System.out.println(item.getCode());
                System.out.println(item.getLogs().size());
                System.out.println("============");
            }
            System.out.println("----------");
            List<Player> players = playerService.getAll();
            
            for(Player item : players){
                System.out.println("Nick: " + item.getNick());
                List<Cachelog> logs = item.getLogs();                
                if(logs!=null){
                    if(logs.size()>0){
                        System.out.println("LOGS size: " + logs.size());
                        for(Cachelog log : logs){
                            System.out.println("Log id: " + log.getId());
                            System.out.println("Log desc: " + log.getDesc());
                            System.out.println("Log created: " + log.getCreated().toString());
                            //System.out.println("Cache code: " + log.getGeocache().getCode());
                            System.out.println("Player member: " + log.getPlayer().getMember());
                        }
                        System.out.println("============");
                    } else {
                        System.out.println("SIZE = 0");
                    }
                }else {
                    System.out.println("LOGS NULL");
                }
                
            }
            
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            
            List<Cachelog> logsTest = cachelogSevice.getAll();
            if(logsTest!=null){
                    if(logsTest.size()>0){
                        for(Cachelog log : logsTest){
                            System.out.println("Cache code: " + log.getGeocache().getCode());
                        }
                        System.out.println("============");
                    } else {
                        System.out.println("SIZE = 0");
                    }
                }else {
                    System.out.println("LOGS NULL");
                }
            
            return model;
	}
		
}
