package bg.DNDWarehouse.warehouseApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int storage_space;
    private String freeSectorAndSpot;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "warehouse")
    private Set<Packet> packets;

    public Warehouse(int storage_space, String freeSectorAndSpot, City city, Set<Packet> packets) {
        this.storage_space = storage_space;
        this.freeSectorAndSpot = freeSectorAndSpot;
        this.city = city;
        this.packets = packets;
    }

    public Warehouse(){};

    public Long getId() {
        return id;
    }

    public int getStorage_space() {
        return storage_space;
    }

    public void setStorage_space(int storage_space) {
        this.storage_space = storage_space;
    }

    public String getFreeSectorAndSpot() {
        return freeSectorAndSpot;
    }

    public void setFreeSectorAndSpot(String freeSectorAndSpot) {
        this.freeSectorAndSpot = freeSectorAndSpot;
    }

    public Set<Packet> getPackets() {
        return packets;
    }

    public void setPackets(Set<Packet> packets) {
        this.packets = packets;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
