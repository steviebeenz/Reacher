package com.github.steviebeenz.reacher;

import java.util.List;
import java.util.ArrayList;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.entity.EntityType; 
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.Player;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.Location;

public class Reacher {
    public static boolean checkReach(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager(); 
        Entity damagee = event.getEntity(); 
        if (damager instanceof Player) {
        Player player = (Player) damager;
        List<EntityType> thingEntities = new ArrayList<EntityType>();
        for(Entity e : player.getNearbyEntities(3, 3, 3)){
            if(e.getType() == damagee.getType()){
                thingEntities.add(damagee.getType());
            }
        }
        if (thingEntities.size() < 1 && event.getCause() == DamageCause.ENTITY_ATTACK) {
            return true;
        } else {
            return false;
        }
        }
        return false;
    }
}