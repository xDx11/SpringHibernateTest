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
        
        //testPlayerCriteria();
        
        Geocache geocache = new Geocache();
        geocache.setName("TestName");
        geocache.setCode("GC12345");
        System.out.println(geocache.getName());
        int id = geocacheService.addGeoObject(geocache);        
        System.out.println("id: " + id);
        
        return model;
    }

    public void testBaseServices() {
        Geocache geocache = geocacheService.getGeoObject(1);
        System.out.println(geocache.getId());
        System.out.println(geocache.getName());
        System.out.println(geocache.getCode());
        System.out.println("----------");
        List<Geocache> caches = geocacheService.getGeoList();
        for (Geocache item : caches) {
            System.out.println(item.getId());
            System.out.println(item.getName());
            System.out.println(item.getCode());
            System.out.println(item.getLogs().size());
            System.out.println("============");
        }
        System.out.println("----------");
        List<Player> players = playerService.getAll();

        for (Player item : players) {
            System.out.println("Nick: " + item.getNick());
            List<Cachelog> logs = item.getLogs();
            if (logs != null) {
                if (logs.size() > 0) {
                    System.out.println("LOGS size: " + logs.size());
                    for (Cachelog log : logs) {
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
            } else {
                System.out.println("LOGS NULL");
            }

        }

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        List<Cachelog> logsTest = cachelogSevice.getAll();
        if (logsTest != null) {
            if (logsTest.size() > 0) {
                for (Cachelog log : logsTest) {
                    System.out.println("Cache code: " + log.getGeocache().getCode());
                }
                System.out.println("============");
            } else {
                System.out.println("SIZE = 0");
            }
        } else {
            System.out.println("LOGS NULL");
        }
    }
    
    public void testGeocacheCriteria(){
        //List<Geocache> caches = geocacheService.getCachesByName("ach"); //WORK
        //List<Geocache> caches = geocacheService.getCachesBySize(2.0, "eq"); //WORK
        //List<Geocache> caches = geocacheService.getCachesBySize(3.0, "less"); //WORK
        List<Geocache> caches = geocacheService.getCachesWithMostLogs(); // WORK
        for (Geocache item : caches) {
            System.out.println(item.getId());
            System.out.println(item.getName());
            System.out.println(item.getCode());
            System.out.println(item.getLogs().size());
            System.out.println("============");
        }
        
        System.out.println("Test AVG diff caches");
        double d = geocacheService.getAvfCachesDiff();
        System.out.println("AVG diff: " + d);
    }
    
    public void testPlayerCriteria(){
        //List<Player> players = playerService.getAll(); //WORK
        //List<Player> players = playerService.getPlayersByName("da"); //WORK
        //List<Player> players = playerService.getPlayersByType("basic"); //WORK
        List<Player> players = playerService.getPlayersWithMostLogs();

        for (Player item : players) {
            System.out.println("Nick: " + item.getNick());            
            System.out.println("Type: " + item.getMember());
            System.out.println("Registered: " + item.getRegistered().toString());
            System.out.println("Count logs: " + item.getLogs().size());
            System.out.println("============");
        }
    }

}
