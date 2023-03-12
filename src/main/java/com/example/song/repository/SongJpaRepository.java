package com.example.song.repository;

import com.example.song.model.Song;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
 
@Repository
public interface SongJpaRepository extends JpaRepository<Song, Integer> {
   

}