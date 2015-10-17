package me.h3x0rz.osr;

import me.h3x0rz.osr.replay.ReplayElement;
import me.h3x0rz.osr.replay.ReplayParser;
import me.h3x0rz.util.ByteOutput;
import me.h3x0rz.util.LZMADeCompressor;

import java.util.List;

public class OSRData {

    private Gamemodes gamemode;
    private byte rawGamemode;
    private int version;
    private String mapMD5;
    private String playerName;
    private String replayMD5;
    private short threehundreds;
    private short onehundreds;
    private short fifties;
    private short gekis;
    private short katus;
    private short misses;
    private int totalScore;
    private short greatestCombo;
    private byte perfect;
    private List<Mods> modsUsed;
    private String lifeGraph;
    private long timestamp;
    private int replayDataLength;
    private ReplayElement[] replay;
    byte[] rawReplay;

    public OSRData(byte gamemode, int version, String mapMD5, String playerName, String replayMD5, short threehundreds, short onehundreds, short fifties, short gekis, short katus, short misses, int totalScore, short greatestCombo, byte perfect, int modsUsed, String lifeGraph, long timestamp, int replayDataLength, byte[] compressedReplay) {
        this.gamemode = Gamemodes.get(gamemode);
        this.rawGamemode = gamemode;
        this.version = version;
        this.mapMD5 = mapMD5;
        this.playerName = playerName;
        this.replayMD5 = replayMD5;
        this.threehundreds = threehundreds;
        this.onehundreds = onehundreds;
        this.fifties = fifties;
        this.gekis = gekis;
        this.katus = katus;
        this.misses = misses;
        this.totalScore = totalScore;
        this.greatestCombo = greatestCombo;
        this.perfect = perfect;
        this.modsUsed = Mods.getUsedMods(modsUsed);
        this.lifeGraph = lifeGraph;
        this.timestamp = timestamp;
        this.replayDataLength = replayDataLength;
        this.replay = ReplayParser.parse(LZMADeCompressor.decompress(compressedReplay));
        this.rawReplay = compressedReplay;
    }

    public Gamemodes getGamemode() {
        return gamemode;
    }

    public int getVersion() {
        return version;
    }

    public String getMapMD5() {
        return mapMD5;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getReplayMD5() {
        return replayMD5;
    }

    public short getThreehundreds() {
        return threehundreds;
    }

    public short getOnehundreds() {
        return onehundreds;
    }

    public short getFifties() {
        return fifties;
    }

    public short getGekis() {
        return gekis;
    }

    public short getKatus() {
        return katus;
    }

    public short getMisses() {
        return misses;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public short getGreatestCombo() {
        return greatestCombo;
    }

    public byte getPerfect() {
        return perfect;
    }

    public List<Mods> getModsUsed() {
        return modsUsed;
    }

    public String getLifeGraph() {
        return lifeGraph;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getReplayDataLength() {
        return replayDataLength;
    }

    public ReplayElement[] getReplay() {
        return replay;
    }

    public void encode(ByteOutput out){
        out.writeByte(this.rawGamemode);
        out.writeInt(this.version);
        out.writeString(this.mapMD5);
        out.writeString(this.playerName);
        out.writeString(this.replayMD5);
        out.writeShort(this.threehundreds);
        out.writeShort(this.onehundreds);
        out.writeShort(this.fifties);
        out.writeShort(this.gekis);
        out.writeShort(this.katus);
        out.writeShort(this.misses);
        out.writeInt(this.totalScore);
        out.writeShort(this.greatestCombo);
        out.writeByte(this.perfect);
        out.writeInt(Mods.reverseMods(this.modsUsed));
        out.writeString(this.lifeGraph);
        out.writeLong(this.timestamp);
        out.writeInt(this.replayDataLength);
        out.writeByteArray(ReplayParser.unparse(this.replay));
    }
}
