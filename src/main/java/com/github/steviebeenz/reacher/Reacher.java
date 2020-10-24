package com.github.steviebeenz.reacher;

import org.bukkit.scheduler.BukkitRunnable;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.entity.EntityType; 
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.Player;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.*;
import org.bukkit.Location;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.scheduler.BukkitScheduler;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import java.util.concurrent.TimeUnit;

public class Reacher {
    public static int getDistance(Player e){
        Location loc = e.getLocation().clone();
        double y = loc.getBlockY();
        int distance = 0;
        for (double i = y; i >= 0; i--){
            loc.setY(i);
            if(loc.getBlock().getType().isSolid())break;
            distance++;
        }
        return distance;
    }
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