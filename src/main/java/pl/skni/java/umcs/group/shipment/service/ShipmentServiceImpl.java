package pl.skni.java.umcs.group.shipment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.skni.java.umcs.group.shipment.model.Shipment;
import pl.skni.java.umcs.group.shipment.model.ShipmentStatus;
import pl.skni.java.umcs.group.shipment.model.ShipmentType;
import pl.skni.java.umcs.group.shipment.repository.ShipmentRepository;

import pl.skni.java.umcs.group.order.model.Order;

import java.util.List;


@Service
public class ShipmentServiceImpl implements ShipmentService {

    ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public List<Shipment> findByStatus(ShipmentStatus status) {
        return shipmentRepository.findByStatus(status);
    }

    @Override
    public List<Shipment> findByType(ShipmentType type) {
        return shipmentRepository.findByType(type);
    }

    @Override
    public Shipment findByOrderId(Integer orderId) {
        return shipmentRepository.findByOrderOrderId(orderId);
    }

    @Override
    public Shipment createShipment(Order order, ShipmentStatus status, ShipmentType type) {
        Shipment shipment = new Shipment(order, status, type);
        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment findById(Integer shipmentId) {
        return shipmentRepository.findOne(shipmentId);
    }

    @Override
    public Shipment setShipmentType(Integer shipmentId, ShipmentType shipmentType) {
        Shipment shipment = findById(shipmentId);
        shipment.setType(shipmentType);
        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment setShipmentStatus(Integer shipmentId, ShipmentStatus shipmentStatus) {
        Shipment shipment = findById(shipmentId);
        shipment.setStatus(shipmentStatus);
        return shipmentRepository.save(shipment);
    }


}
