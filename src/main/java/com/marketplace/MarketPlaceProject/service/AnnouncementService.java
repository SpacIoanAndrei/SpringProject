package com.marketplace.MarketPlaceProject.service;

import com.marketplace.MarketPlaceProject.entity.Announcement;
import com.marketplace.MarketPlaceProject.error.AnnouncementNotFoundException;

import java.util.List;

public interface AnnouncementService {
    public Announcement saveAnnouncement(Announcement announcement);

    public List<Announcement> fetchAnnouncementList();

    public Announcement fetchAnnouncementById(Long announcementId) throws AnnouncementNotFoundException;

    public void deleteAnnouncementById(Long announcementId);

    public Announcement updateAnnouncement(Long announcementId, Announcement announcement);

    public Announcement fetchAnnouncementByName(String announcementName);

    public List<Announcement> fetchAnnouncementByCategory(String announcementCategory);

    public List<Announcement> fetchAnnouncementByPrice(String announcementPrice);

    public List<Announcement> findByAnnouncementCityIgnoreCase(String announcementCity);
}
