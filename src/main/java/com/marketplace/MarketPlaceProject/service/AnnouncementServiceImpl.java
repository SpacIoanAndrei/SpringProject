package com.marketplace.MarketPlaceProject.service;

import com.marketplace.MarketPlaceProject.entity.Announcement;
import com.marketplace.MarketPlaceProject.error.AnnouncementNotFoundException;
import com.marketplace.MarketPlaceProject.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Scope("singleton")
public class AnnouncementServiceImpl implements AnnouncementService{

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Override
    public Announcement saveAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    @Override
    public List<Announcement> fetchAnnouncementList() {
        return announcementRepository.findAll();
    }

    @Override
    public Announcement fetchAnnouncementById(Long announcementId) throws AnnouncementNotFoundException {
       Optional<Announcement> ann = announcementRepository.findById(announcementId);
       if (!ann.isPresent()){
           throw new AnnouncementNotFoundException("Announcement not available!");
       }
       return ann.get();
    }

    @Override
    public void deleteAnnouncementById(Long announcementId) {
        announcementRepository.deleteById(announcementId);
    }

    @Override
    public Announcement updateAnnouncement(Long announcementId, Announcement announcement) {
        Announcement annFromDb = announcementRepository.getById(announcementId);

        if (Objects.nonNull(announcement.getAnnouncementName()) && !"".equals(announcement.getAnnouncementName())){
            annFromDb.setAnnouncementName(announcement.getAnnouncementName());
        }
        if (Objects.nonNull(announcement.getAnnouncementCity()) && !"".equals(announcement.getAnnouncementCity())){
            annFromDb.setAnnouncementCity(announcement.getAnnouncementCity());
        }
        if (Objects.nonNull(announcement.getAnnouncementDescription()) && !"".equals(announcement.getAnnouncementDescription())){
            annFromDb.setAnnouncementDescription(announcement.getAnnouncementDescription());
        }
        if (Objects.nonNull(announcement.getCategory()) && !"".equals(announcement.getCategory())){
            annFromDb.setCategory(announcement.getCategory());
        }
        if (Objects.nonNull(announcement.getPrice()) && !"".equals(announcement.getPrice())){
            annFromDb.setPrice(announcement.getPrice());
        }
        if (Objects.nonNull(announcement.getPhoneNumber()) && !"".equals(announcement.getPhoneNumber())){
            annFromDb.setPhoneNumber(announcement.getPhoneNumber());
        }
        return announcementRepository.save(annFromDb);
    }

    @Override
    public Announcement fetchAnnouncementByName(String announcementName) {
        return announcementRepository.findByAnnouncementNameIgnoreCase(announcementName);
    }

    @Override
    public List<Announcement> fetchAnnouncementByCategory(String announcementCategory) {
        return announcementRepository.findByCategoryIgnoreCase(announcementCategory);
    }

    @Override
    public List<Announcement> fetchAnnouncementByPrice(String announcementPrice) {
        return announcementRepository.findByPrice(announcementPrice);
    }

    @Override
    public List<Announcement> findByAnnouncementCityIgnoreCase(String announcementCity) {
        return announcementRepository.findByAnnouncementCityIgnoreCase(announcementCity);
    }

}
