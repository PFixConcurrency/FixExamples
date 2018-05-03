/*
 * 
 * Copyright (c) 2000-2005 Standard Performance Evaluation Corporation (SPEC) All
 * rights reserved. Copyright (c) 1996-2005 IBM Corporation, Inc. All rights
 * reserved.
 * 
 */
package spec.jbb;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigDecimal;

public class District {
    // This goes right after each class/interface statement
    static final String      COPYRIGHT = "SPECjbb2005,"
                                               + "Copyright (c) 2000-2005 Standard Performance Evaluation Corporation (SPEC),"
                                               + "All rights reserved,"
                                               + "(C) Copyright IBM Corp., 1996 - 2005"
                                               + "All rights reserved,"
                                               + "Licensed Materials - Property of SPEC";

    private JBBSortedStorage orderTable;

    private JBBSortedStorage newOrderTable;

    // required
    private String           name;

    private Address          address;

    private BigDecimal       taxRate;

    private BigDecimal       ytd;

    private int              nextOrder;

    private byte             districtId;

    private short            warehouseId;

    private int              oldestOrder;

    public District(short inWarehouseId, byte inDistrictId) {
        districtId = inDistrictId;
        warehouseId = inWarehouseId;
        address = new Address();
        nextOrder = 1;
        orderTable = Infrastructure.createSortedStorage();
        newOrderTable = Infrastructure.createSortedStorage();
    }

    public int getId() {
        return districtId;
    };

    public BigDecimal getTaxRate() {
        return taxRate;
    };

    public Address getAddress() {
        return address;
    }

    public int lastOrderId() {
        int temp = nextOrder - 1;
        return temp;
    }

    public int nextOrderId() {
        int temp = nextOrder++;
        return temp;
    }

    public void display() {
        System.out.println("District display ****************************");
        System.out.println("districtId is ======== " + districtId);
        System.out.println("warehouseID == " + warehouseId);
        System.out.println("name is   ==== " + name);
        address.display();
        System.out.println("*********************************************");
    }

    public void receivePayment(BigDecimal paymentAmount) {
        ytd = ytd.add(paymentAmount);
    }

    public void setUsingRandom() {
        name = new String(JBButil.create_random_a_string(6, 10, warehouseId));
        address.setUsingRandom(warehouseId); // address
        float temp = JBButil.create_random_float_val_return(0.0f, 0.2000f,
                0.0001f, warehouseId);
        taxRate = new BigDecimal(temp).setScale(4, BigDecimal.ROUND_HALF_UP); // tax
        // rate
        ytd = BigDecimal.valueOf(3000000L, 2);
    }

    public void addOrder(Order anOrder) {
        orderTable.put(anOrder.getId(), anOrder);
    }

    public Order retrieveOrder(Order order) {
        return (Order) orderTable.get(order.getId());
    }

    public void removeOldestOrder() {
        oldestOrder++;
        boolean removed = orderTable.deleteFirstEntities();
        if (!removed) {
            JBButil.getLog().warning(
                    "District.removeOldestOrder failed for orderId="
                            + oldestOrder + ", districtId=" + districtId
                            + ", warehouseId=" + warehouseId);
        }
    }

    public void removeOldOrders(int minOrders) {
        int size = orderTable.size();
        boolean removed = orderTable.deleteFirstEntities(size - minOrders);
        if (removed) {
            oldestOrder += size - minOrders;
        }
        else {
            JBButil.getLog().warning(
                    "District.removeOldOrders failed for " + ", districtId="
                            + districtId + ", warehouseId=" + warehouseId
                            + ", size=" + orderTable.size());
        }
        if (JBButil.getLog().isLoggable(Level.FINEST)) {
            Logger log = JBButil.getLog();
            log.finest("SteadyState trimmed orderTable to "
                    + (orderTable.size()) + " elements, from " + size
                    + " elements");
            log.finest("  for districtId=" + districtId + " warehouseId="
                    + warehouseId);
        }
    }

    public void removeOldNewOrders(int minNewOrders) {
        int size = newOrderTable.size();
        boolean removed = newOrderTable
                .deleteFirstEntities(size - minNewOrders);
        if (!removed) {
            JBButil.getLog().warning(
                    "District.removeOldNewOrders failed for " + ", districtId="
                            + districtId + ", warehouseId=" + warehouseId
                            + ", size=" + newOrderTable.size());
        }
        if (JBButil.getLog().isLoggable(Level.FINEST)) {
            Logger log = JBButil.getLog();
            log.finest("SteadyState trimmed newOrderTable to "
                    + newOrderTable.size() + " elements, from " + size
                    + " elements");
            log.finest("  for districtId=" + districtId + ", warehouseId="
                    + warehouseId);
        }
    }

    public void addNewOrder(NewOrder aNewOrder) {
        newOrderTable.put(aNewOrder.getId(), aNewOrder);
    }

    public NewOrder removeFirstNewOrder() {
        NewOrder temp = null;
        temp = (NewOrder) newOrderTable.removeFirstElem();
        return temp;
    }

    public JBBDataStorage getOrderTable() {
        return orderTable;
    }

    public String getName() {
        return name;
    }

    public Iterator newOrderIter() {
        return (Iterator) newOrderTable.elements();
    }

    public NewOrder removeNewOrder(Object key) {
        NewOrder temp = (NewOrder) newOrderTable.get(key);
        return (NewOrder) newOrderTable.remove(key);
    }
}
