package com.marketplace.MarketPlaceProject.repository;

import com.marketplace.MarketPlaceProject.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    //conventie: findBy+(name of entity attribute)
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
    public Announcement findByAnnouncementNameIgnoreCase(String announcementName);

    public List<Announcement> findByCategoryIgnoreCase(String announcementCategory);

    public List<Announcement> findByPrice(String announcementPrice);

    public List<Announcement> findByAnnouncementCityIgnoreCase(String announcementCity);
}
