package de.melonigemelone.miktoyaapi.api.coinssysteme.economy;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class EconomyImpl implements Economy {


    public boolean isEnabled() {
        return true;
    }

    public String getName() {
        return "EconomySystem by MelonigeMelone";
    }

    public boolean hasBankSupport() {
        return false;
    }

    public int fractionalDigits() {
        return 2;
    }

    public String format(double v) {
        BigDecimal bd = new BigDecimal(v).setScale(2, RoundingMode.HALF_EVEN);
        return String.valueOf(bd.doubleValue());
    }

    public String currencyNamePlural() {
        return "Euro";
    }

    public String currencyNameSingular() {
        return "Euro";
    }

    public boolean hasAccount(String s) {
        return hasAccount(Bukkit.getOfflinePlayer(s));
    }

    public boolean hasAccount(OfflinePlayer offlinePlayer) {
        return MiktoyaAPI.getEconomyMySQL().existsPlayer(offlinePlayer.getUniqueId().toString());
    }

    public boolean hasAccount(String s, String s1) {
        return hasAccount(Bukkit.getOfflinePlayer(s));
    }

    public boolean hasAccount(OfflinePlayer offlinePlayer, String s) {
        return hasAccount(offlinePlayer);
    }

    public double getBalance(String s) {
        return getBalance(Bukkit.getOfflinePlayer(s));
    }

    public double getBalance(OfflinePlayer offlinePlayer) {
        return EconomyAPI.getEconomyData(offlinePlayer.getUniqueId().toString()).getMoney();
    }

    public double getBalance(String s, String s1) {
        return getBalance(s);
    }

    public double getBalance(OfflinePlayer offlinePlayer, String s) {
        return getBalance(offlinePlayer);
    }

    public boolean has(String s, double v) {
        return has(Bukkit.getOfflinePlayer(s),v);
    }

    public boolean has(OfflinePlayer offlinePlayer, double v) {
        return getBalance(offlinePlayer) >= v;
    }

    public boolean has(String s, String s1, double v) {
        return has(s,v);
    }

    public boolean has(OfflinePlayer offlinePlayer, String s, double v) {
        return has(offlinePlayer,v);
    }

    public EconomyResponse withdrawPlayer(String s, double v) {
        return withdrawPlayer(Bukkit.getOfflinePlayer(s),v);
    }

    public EconomyResponse withdrawPlayer(OfflinePlayer offlinePlayer, double v) {
        EconomyData economyData = EconomyAPI.getEconomyData(offlinePlayer.getUniqueId().toString());
        economyData.removeMoney(v);
        return new EconomyResponse(v, economyData.getMoney(), EconomyResponse.ResponseType.SUCCESS, "");
    }

    public EconomyResponse withdrawPlayer(String s, String s1, double v){
        return withdrawPlayer(s,v);
    }

    public EconomyResponse withdrawPlayer(OfflinePlayer offlinePlayer, String s, double v) {
        return withdrawPlayer(offlinePlayer,v);
    }

    public EconomyResponse depositPlayer(String s, double v) {
        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(s);
        if(offlinePlayer == null){
            offlinePlayer = Bukkit.getPlayer(s);
            if(offlinePlayer != null){
                return depositPlayer(offlinePlayer,v);
            }
        }
        return null;
    }

    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, double v) {
        if(offlinePlayer != null && offlinePlayer.getUniqueId() != null){
            EconomyData economyData = EconomyAPI.getEconomyData(offlinePlayer.getUniqueId().toString());
            economyData.addMoney(v);
            return new EconomyResponse(v,economyData.getMoney(), EconomyResponse.ResponseType.SUCCESS,"");
        }
        return null;
    }

    public EconomyResponse depositPlayer(String s, String s1, double v) {
        return depositPlayer(s,v);
    }

    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, String s, double v) {
        return depositPlayer(offlinePlayer,v);
    }

    public EconomyResponse createBank(String s, String s1) {
        return null;
    }

    public EconomyResponse createBank(String s, OfflinePlayer offlinePlayer) {
        return null;
    }

    public EconomyResponse deleteBank(String s) {
        return null;
    }

    public EconomyResponse bankBalance(String s) {
        return null;
    }

    public EconomyResponse bankHas(String s, double v) {
        return null;
    }

    public EconomyResponse bankWithdraw(String s, double v) {
        return null;
    }

    public EconomyResponse bankDeposit(String s, double v) {
        return null;
    }

    public EconomyResponse isBankOwner(String s, String s1) {
        return null;
    }

    public EconomyResponse isBankOwner(String s, OfflinePlayer offlinePlayer) {
        return null;
    }

    public EconomyResponse isBankMember(String s, String s1) {
        return null;
    }

    public EconomyResponse isBankMember(String s, OfflinePlayer offlinePlayer) {
        return null;
    }

    public List<String> getBanks() {
        return null;
    }

    public boolean createPlayerAccount(String s) {
        return createPlayerAccount(Bukkit.getOfflinePlayer(s));
    }

    public boolean createPlayerAccount(OfflinePlayer offlinePlayer) {
        String uuid = offlinePlayer.getUniqueId().toString();
        if(!MiktoyaAPI.getEconomyMySQL().existsPlayer(uuid)){
            MiktoyaAPI.getEconomyMySQL().createPlayer(uuid);
            return true;
        }
        return true;
    }

    public boolean createPlayerAccount(String s, String s1) {
        return false;
    }

    public boolean createPlayerAccount(OfflinePlayer offlinePlayer, String s) {
        return false;
    }
}
