package com.github.unchama.gui.admin.toolrepair;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.unchama.gigantic.Gigantic;
import com.github.unchama.gigantic.PlayerManager;
import com.github.unchama.gui.GuiMenu;
import com.github.unchama.gui.GuiMenu.ManagerType;
import com.github.unchama.gui.admin.AdminTypeMenuManager;
import com.github.unchama.gui.moduler.GuiMenuManager;
import com.github.unchama.player.GiganticPlayer;
import com.github.unchama.toolrepair.ToolRepair;
import com.github.unchama.util.Util;
import com.github.unchama.yml.CustomHeadManager;

public class AdminToolRepairMenuManager extends GuiMenuManager{

	// 戻るボタン
	private ItemStack backButton;
	private final int backButtonSlot = 18;

	// ツール全修理
	ItemStack repairFreeButton;
	private final int repairFreeSlot = 0;

	// ツール全損
	ItemStack repairDamageButton;
	private final int repairDamageSlot = 1;

	private CustomHeadManager headManager = Gigantic.yml
			.getManager(CustomHeadManager.class);

	public AdminToolRepairMenuManager(){
		// 戻るボタン
		backButton = headManager.getMobHead("left");
		Util.setDisplayName(backButton, "戻る");
		// ツール全修理
		repairFreeButton = new ItemStack(Material.ANVIL);
		Util.setDisplayName(repairFreeButton, "ツール全修理");
		Util.setLore(repairFreeButton, "手持ちのツールを無条件で修理");
		// ツール全損
		repairDamageButton = new ItemStack(Material.STONE_PICKAXE);
		Util.setDisplayName(repairDamageButton, "ツール全損");
		Util.setLore(repairDamageButton, "手持ちのツールを耐久値0");

		// Invoke設定
		for (int i = 0; i < getInventorySize(); i++) {
			id_map.put(i, Integer.toString(i));
		}

		setOpenMenuMap(openmap);
	}

	@Override
	protected void setIDMap(HashMap<Integer, String> idmap) {

	}

	@Override
	public Inventory getInventory(Player player, int slot) {
		GiganticPlayer gp = PlayerManager.getGiganticPlayer(player);

		// インベントリ基本情報
		Inventory inv = Bukkit.getServer().createInventory(player,
				this.getInventorySize(), this.getInventoryName(player));

		//戻るボタン
		inv.setItem(backButtonSlot, backButton);
		//ツール全修理
		inv.setItem(repairFreeSlot, repairFreeButton);
		//ツール全損
		inv.setItem(repairDamageSlot, repairDamageButton);

		return inv;
	}

	@Override
	public boolean invoke(Player player, String identifier) {
		int slot;
		try {
			slot = Integer.valueOf(identifier);
		} catch (NumberFormatException nfex) {
			return false;
		}

		if(slot == repairFreeSlot){
			ToolRepair.RepairTool(player, ToolRepair.RepairType.Free);
		}else if(slot == repairDamageSlot){
			ToolRepair.RepairTool(player, ToolRepair.RepairType.Damage);
		}

		return true;
	}

	@Override
	protected void setOpenMenuMap(HashMap<Integer, ManagerType> openmap) {
		// 戻るボタンでメインメニューを開く
		openmap.put(backButtonSlot,
				GuiMenu.ManagerType.getTypebyClass(AdminTypeMenuManager.class));


	}

	@Override
	protected void setKeyItem() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public String getClickType() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public int getInventorySize() {
		return 9 * 3;
	}

	@Override
	public String getInventoryName(Player player) {
		return "ツール耐久値操作";
	}

	@Override
	protected InventoryType getInventoryType() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	protected ItemMeta getItemMeta(Player player, int slot, ItemStack itemstack) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	protected ItemStack getItemStack(Player player, int slot) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Sound getSoundName() {
		return Sound.BLOCK_ANVIL_PLACE;
	}

	@Override
	public float getVolume() {
		return 1;
	}

	@Override
	public float getPitch() {
		return 0.5f;
	}
}