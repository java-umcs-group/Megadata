package pl.skni.java.umcs.group.shipment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skni.java.umcs.group.shipment.model.Shipment;
import pl.skni.java.umcs.group.shipment.model.ShipmentStatus;
import pl.skni.java.umcs.group.shipment.model.ShipmentType;

import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment,Integer>{
    List<Shipment> findByStatus(ShipmentStatus status);
    List<Shipment> findByType(ShipmentType type);
    Shipment findByOrderOrderId(Integer orderId);
}
