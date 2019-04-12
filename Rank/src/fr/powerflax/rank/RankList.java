package fr.powerflax.rank;

public enum RankList {
	
	AMINISTRATOR(0, 100,"§4Admin " ,""," §8§1>> §4"),
	MODERATOR(0, 50,"§2Modérateur " ,""," §8§1>> §2"),
	PLAYER(0, 1, "§3Joueur " ,"", "§8§7>> §7"); 
	
	//Ici le prefix
	private final int power, id;
	public final String prefix, suffix, chatSeparator;
	
	private RankList(int id,int power, String prefix, String suffix, String chatSeparator){
		this.id=id;
		this.power=power;
		this.prefix=prefix;
		this.suffix=suffix;
		this.chatSeparator= chatSeparator;
	}
	public final int getId(){
		return id;
	}
	public final int getPower() {
		return power;
	}
	public final String getprefix() {
		return prefix;
	}
	public final String getsuffix() {
		return suffix;
	}
	public final String getName() {
		return this.toString();
	}
	public final String getChatSeparator() {
		return chatSeparator;
	}
}
