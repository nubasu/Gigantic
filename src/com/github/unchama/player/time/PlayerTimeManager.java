package com.github.unchama.player.time;

import org.bukkit.Location;

import com.github.unchama.gigantic.Gigantic;
import com.github.unchama.gigantic.PlayerManager;
import com.github.unchama.player.GiganticPlayer;
import com.github.unchama.player.moduler.DataManager;
import com.github.unchama.player.moduler.UsingSql;
import com.github.unchama.sql.PlayerTimeTableManager;
import com.github.unchama.util.Util;
import com.github.unchama.yml.DebugManager;
import com.github.unchama.yml.DebugManager.DebugEnum;

public class PlayerTimeManager extends DataManager implements UsingSql {

	//プレイ時間差分計算用int
	public int servertick;
	//プレイ時間
	public int playtick;

	//現在座標
	public Location loc;
	//累計放置時間
	public int totalidletick;
	//放置時間
	public int idletime;

	PlayerTimeTableManager tm = sql.getManager(PlayerTimeTableManager.class);
	DebugManager debug = Gigantic.yml.getManager(DebugManager.class);

	public PlayerTimeManager(GiganticPlayer gp) {
		super(gp);
	}

    @Override
    public void save(Boolean loginflag) {
        tm.save(gp, loginflag);
        debug.sendMessage(PlayerManager.getPlayer(gp),DebugEnum.BUILD,"PlayerTimeManager : save");
    }

	public void init() {
		servertick = 0;
		playtick = 0;
		loc = null;
		totalidletick = 0;
		idletime = 0;
	}

	//10分間動きがなければ放置
	public boolean isIdle(){
		return idletime >= 10;
	}

	//放置時間を除いた累計プレイ時間を「HH時間MM分」の文字列で返す
	public String GetTotalLoginTimeToString(){
		return Util.toTimeString(Util.toSecond(playtick - totalidletick));
	}
}