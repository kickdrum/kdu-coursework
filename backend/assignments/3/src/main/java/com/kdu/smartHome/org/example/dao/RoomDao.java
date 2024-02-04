package org.example.dao;




import org.example.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoomDao extends JpaRepository<Room,Long> {
    @Query
    Optional<Room> findByRoomName(String roomName);
}
