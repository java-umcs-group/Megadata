package pl.skni.java.umcs.group.shipment.service;

import org.junit.Assert;
import org.junit.Test;
import pl.skni.java.umcs.group.ItTestHelper;
import pl.skni.java.umcs.group.shipment.model.Shipment;
import pl.skni.java.umcs.group.shipment.model.ShipmentStatus;
import pl.skni.java.umcs.group.shipment.model.ShipmentType;

import java.util.List;

public class ShipmentServiceTest extends ItTestHelper {

    @Test
    public void shouldfindByStatus() throws Exception {
        //given
        Shipment shipment1 = createShipment();
        Shipment shipment2 = createShipment();
        Shipment shipment3 = createShipment();
        Shipment shipment4 = createShipment();
        Shipment shipment5 = createShipment();

        shipmentService.setShipmentStatus(shipment1.getId(), ShipmentStatus.CANCELED);
        shipmentService.setShipmentStatus(shipment2.getId(), ShipmentStatus.CANCELED);
        shipmentService.setShipmentStatus(shipment3.getId(), ShipmentStatus.CANCELED);
        shipmentService.setShipmentStatus(shipment4.getId(), ShipmentStatus.CANCELED);
        shipmentService.setShipmentStatus(shipment5.getId(), ShipmentStatus.CANCELED);

        //when
        List<Shipment> result = shipmentService.findByStatus(ShipmentStatus.CANCELED);

        //then
        Assert.assertEquals("list size", 5, result.size());
        result.stream().forEach(shipment -> {
            Assert.assertEquals("ShipmentStatus", ShipmentStatus.CANCELED, shipment.getStatus());
        });
    }

    @Test
    public void findByType() throws Exception {
        //given
        Shipment shipment1 = createShipment();
        Shipment shipment2 = createShipment();
        Shipment shipment3 = createShipment();
        Shipment shipment4 = createShipment();
        Shipment shipment5 = createShipment();

        shipmentService.setShipmentType(shipment1.getId(), ShipmentType.PICKUP);
        shipmentService.setShipmentType(shipment2.getId(), ShipmentType.PICKUP);
        shipmentService.setShipmentType(shipment3.getId(), ShipmentType.PICKUP);
        shipmentService.setShipmentType(shipment4.getId(), ShipmentType.PICKUP);
        shipmentService.setShipmentType(shipment5.getId(), ShipmentType.PICKUP);

        //when
        List<Shipment> result = shipmentService.findByType(ShipmentType.PICKUP);

        //then
        Assert.assertEquals("list size", 5, result.size());
        result.stream().forEach(shipment -> {
            Assert.assertEquals("ShipmentStatus", ShipmentType.PICKUP, shipment.getType());
        });
    }

    @Test
    public void findByOrderId() throws Exception {
        //given
        Shipment shipment = createShipment();
        //when
        Shipment result = shipmentService.findByOrderId(shipment.getOrder().getOrderId());
        //then
        Assert.assertEquals("shipmentId", shipment.getId(),result.getId());
    }


}
