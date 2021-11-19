package me.heythigas.tpunir;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import eventos.Eventos;

public class Main extends JavaPlugin {
	
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§6[TPunir] - Iniciado.");
		registro();
	}
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§c[TPunir] - Desligado.");
	}
	public void registro() {
		Bukkit.getPluginManager().registerEvents(new Eventos(), this);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(command.getName().equalsIgnoreCase("punir")) {
				if(p.hasPermission("tpunir.usar")) {
					
				if(args.length == 0) {
					p.sendMessage("§cOps! Utilize: /punir <nick>");
					return true;
				}
				if(args.length > 2) {
					p.sendMessage("§cOps! Utilize: /punir <nick>");
					return true;
				}
				for (Player target : Bukkit.getOnlinePlayers()) {
					if(args[0].equals(target.getName())) {
						target.kickPlayer("§cVocê foi punido deste servidor.");
						target.setBanned(true);
						p.sendMessage("§aO Jogador§7 " + target.getName() + "§a foi punido.");
						Bukkit.broadcastMessage("§cO jogador §7" + target.getName() + "§c foi punido.");
					} else {
						p.sendMessage("§cOps! Este jogador não está online.");
					}
				}
			} else {
				p.sendMessage("§cOps! Você não tem permissão.");
			}
			}
		}
		
		return false;
		
	}

}
