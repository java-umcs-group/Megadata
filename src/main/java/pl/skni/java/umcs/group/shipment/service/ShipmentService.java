package pl.skni.java.umcs.group.shipment.service;

import pl.skni.java.umcs.group.order.model.Order;
import pl.skni.java.umcs.group.shipment.model.Shipment;
import pl.skni.java.umcs.group.shipment.model.ShipmentStatus;
import pl.skni.java.umcs.group.shipment.model.ShipmentType;

import java.util.List;

public interface ShipmentService {
    List<Shipment> findByStatus(ShipmentStatus status);
    List<Shipment> findByType(ShipmentType type);
    Shipment findByOrderId(Integer orderId);
    Shipment createShipment(Order order, ShipmentStatus status, ShipmentType type);
    Shipment findById(Integer shipmentId);
    Shipment setShipmentType(Integer shipmentId, ShipmentType shipmentType);
    Shipment setShipmentStatus(Integer shipmentId, ShipmentStatus shipmentStatus);
}
