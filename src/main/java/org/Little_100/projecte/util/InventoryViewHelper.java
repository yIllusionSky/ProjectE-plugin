package org.Little_100.projecte.util;

import java.lang.reflect.Method;
import org.bukkit.event.inventory.InventoryEvent;

public class InventoryViewHelper {

    private static Method getViewMethod;
    private static Method getTitleMethod;
    private static boolean initialized = false;

    static {
        try {
            getViewMethod = InventoryEvent.class.getMethod("getView");

            Class<?> inventoryViewClass = getViewMethod.getReturnType();
            getTitleMethod = inventoryViewClass.getMethod("getTitle");

            initialized = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getTitle(InventoryEvent event) {
        if (!initialized) {
            return "";
        }

        try {
            Object view = getViewMethod.invoke(event);
            return (String) getTitleMethod.invoke(view);
        } catch (Exception e) {
            return "";
        }
    }
}
