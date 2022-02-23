package com.marketplace.MarketPlaceProject.Controller;

import com.marketplace.MarketPlaceProject.entity.Announcement;
import com.marketplace.MarketPlaceProject.error.AnnouncementNotFoundException;
import com.marketplace.MarketPlaceProject.service.AnnouncementService;
import com.marketplace.MarketPlaceProject.service.AnnouncementServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AnnouncementController {

    @Autowired // AnnouncementService announcementService = new AnnouncementServiceImpl();
    private AnnouncementService announcementService;

    private final Logger LOGGER = LoggerFactory.getLogger(AnnouncementController.class);

    //pass the data to the service layer, where it's business logic,them call the repository layer to save that info
    @PostMapping("/announcements")
    public Announcement saveAnnouncement(@Valid @RequestBody Announcement announcement){ //@Valid = title is mandatory
        LOGGER.info("Inside saveAnnouncement method of AnnouncementController"); //useful for debugging application
        return announcementService.saveAnnouncement(announcement);
    }

    @GetMapping("/announcements")
    public List<Announcement> fetchAnnouncementList(){
        return announcementService.fetchAnnouncementList();
    }

    @GetMapping("/announcements/{id}")
    public Announcement fetchAnnouncementById (@PathVariable("id") Long announcementId) throws AnnouncementNotFoundException {
        return announcementService.fetchAnnouncementById(announcementId);
    }

    @DeleteMapping("/announcements/{id}")
    public String deleteAnnouncementById(@PathVariable("id") Long announcementId){
        announcementService.deleteAnnouncementById(announcementId);
        return "Announcement deleted succesfully!";
    }

    @PutMapping("/announcements/{id}")
    public Announcement updateAnnouncement (@PathVariable("id") Long announcementId, @RequestBody Announcement announcement){
        return announcementService.updateAnnouncement(announcementId, announcement);
    }

    @GetMapping("/announcements/name/{name}")
    public Announcement fetchAnnouncementByName (@PathVariable("name") String announcementName){
        return announcementService.fetchAnnouncementByName(announcementName);
    }
    @GetMapping("/announcements/category/{category}")
    public List<Announcement> fetchAnnouncementByCategory (@PathVariable("category") String announcementCategory){
        return announcementService.fetchAnnouncementByCategory(announcementCategory);
    }
    @GetMapping("/announcements/price/{price}")
    public List<Announcement> fetchAnnouncementByPrice (@PathVariable("price") String announcementPrice){
        return announcementService.fetchAnnouncementByPrice(announcementPrice);
    }
    @GetMapping("/announcements/city/{city}")
    public List<Announcement> fetchAnnouncementByCity (@PathVariable("city") String announcementCity){
        return announcementService.findByAnnouncementCityIgnoreCase(announcementCity);
    }
}
