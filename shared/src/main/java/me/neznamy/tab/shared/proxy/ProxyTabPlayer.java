package me.neznamy.tab.shared.proxy;

import me.neznamy.tab.shared.ITabPlayer;
import me.neznamy.tab.shared.features.PluginMessageHandler;

public abstract class ProxyTabPlayer extends ITabPlayer {

	private PluginMessageHandler plm;
	
	protected ProxyTabPlayer(PluginMessageHandler plm) {
		this.plm = plm;
	}
	
	@Override
	public boolean isVanished() {
		return getAttribute("vanished");
	}
	
	@Override
	public boolean isDisguised() {
		return getAttribute("disguised");
	}
	@Override
	public boolean hasInvisibilityPotion() {
		return getAttribute("invisible");
	}
	
	private boolean getAttribute(String name) {
		plm.requestAttribute(this, name);
		if (!attributes.containsKey(name)) return false;
		return Boolean.parseBoolean(attributes.get(name));
	}
}