package org.screamingsandals.simpleinventories.events;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.screamingsandals.simpleinventories.inventory.GenericItemInfo;
import org.screamingsandals.simpleinventories.inventory.Inventory;
import org.screamingsandals.simpleinventories.inventory.PlayerItemInfo;
import org.screamingsandals.simpleinventories.inventory.SubInventory;
import org.screamingsandals.simpleinventories.utils.ClickType;
import org.screamingsandals.simpleinventories.wrapper.PlayerWrapper;

@Data
@RequiredArgsConstructor
public class PreClickEvent implements Cancellable {
    private final PlayerWrapper player;
    private final Inventory format;
    // Bukkit's Inventory inv
    private final GenericItemInfo parent;
    private final PlayerItemInfo item;
    private final ClickType clickType;
    private final SubInventory subInventory;

    private boolean cancelled;

    /*public boolean hasItem() {
        return item != null;
    }*/
}