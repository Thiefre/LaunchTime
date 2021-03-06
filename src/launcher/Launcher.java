package launcher;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.TreeMap;

import data.Game;
import data.GameTree;

public class Launcher 
{
	public GameTree g = new GameTree();
	public static TreeMap<String, String> games = new TreeMap<String, String>();
	File f = new File("C:/LaunchTime/data.txt");
	
	public Launcher()
	{
		initGames();
		try {
			hasGames();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void hasGames() throws IOException
	{
		if(f.exists())
		{
				Reader r = new FileReader(f);
				BufferedReader br = new BufferedReader(r);
				String s = br.readLine();
				while(s != null)
				{
					String[] as = s.split("@");
					g.insert(new Game(as[0], as[1]));
					s = br.readLine();
				}
		}
	}
	
	public void searchGames(File f)
	{
		
		if(f.listFiles() != null)
		{
		File[] files = f.listFiles();
		for(File file : files)
		{
			if(file.isDirectory() && AcceptedFile.isAccepted(file) == AcceptedFile.ACCEPT)
			{
				searchGames(file);
			}
			else if(file.canExecute() && isGame(file))
			{
				Game game = new Game(games.get(file.getName()), file.getAbsolutePath());				
				g.insert(new Game(game.name, game.path));
			}
		}
		}
	}
	
	public boolean isGame(File f)
	{
		if(games.get(f.getName()) != null)
		{
			return true;
		}
		return false;
	}
	
	
	private static void initGames()
	{
		games.put("pol.exe", "FINAL FANTASY XI");
		games.put("ffxiv.exe", "FINAL FANTASY XIV");
		games.put("Wow.exe", "World of Warcraft");
		games.put("LeagueClient.exe", "League of Legends");
		games.put("Diablo III.exe", "Diablo 3");
		games.put("dota2.exe", "DOTA 2");
		games.put("Heroes of the Storm.exe", "Heroes of the Storm");
		games.put("Hearthstone.exe", "Hearthstone");
		games.put("csgo.exe", "Counter-Strike: Global Offensive");
		games.put("WorldOfTanks.exe", "World of Tanks");
		games.put("gw2.exe", "Guild Wars 2");
		games.put("dayz.exe", "Day Z");
		games.put("starcraft ii.exe", "Starcraft II");
		games.put("diablo.exe", "Diablo");
		games.put("diablo ii.exe", "Diablo 2");
		games.put("left4dead.exe", "Left 4 Dead");
		games.put("MinecraftLauncher.exe", "Minecraft");
		games.put("smite.exe", "Smite");
		games.put("bf4.exe", "Battlefield 4");
		games.put("AoK HD.exe", "Age of Empires II");
		games.put("age3y.exe", "Age of Empires III");
		games.put("AlanWake.exe", "Alan Wake");
		games.put("alan_wakes_american_nightmare.exe", "Alan Wake's American Nightmare");
		games.put("AlienBreed2Assault.exe", "Alien Breed 2: Assault");
		games.put("Amnesia.exe", "Amnesia: The Dark Descent");
		games.put("UDK.exe", "Antichamber");
		games.put("ArcheAge.exe", "ArcheAge");
		games.put("arma3.exe", "Arma III");
		games.put("AC3SP.exe", "Assassin's Creed 3");
		games.put("Bastion.exe", "Bastion");
		games.put("BF2.exe", "Battlefield 2");
		games.put("bf3.exe", "Battlefield 3");
		games.put("Besiege.exe", "Besiege");
		games.put("Bioshock.exe", "Bioshock");
		games.put("Bioshock2.exe", "BioShock II");
		games.put("BioShockInfinite.exe", "BioShock Infinite");
		games.put("Borderlands2.exe", "Borderlands 2");
		games.put("braid.exe", "Braid");
		games.put("ShippingPC-StormGame.exe", "Bulletstorm");
		games.put("cabal2main.exe", "Cabal 2");
		games.put("CabalMain.exe", "Cabal Online");
		games.put("iw4mp.exe", "Call of Duty: Modern Warfare 2");
		games.put("t6sp.exe", "Call of Duty: Black Ops");
		games.put("iw5mp.exe", "Call of Duty: Modern Warfare 3");
		games.put("RelicCOH.exe", "Company of Heroes");
		games.put("Crysis64.exe", "Crysis");
		games.put("Crysis2.exe", "Crysis 2");
		games.put("Crysis3.exe", "Crysis 3");
		games.put("Crysis.exe", "Crysis 4  ");
		games.put("DATA.exe", "Dark Souls");
		games.put("DarkSoulsII.exe", "Dark Souls II");
		games.put("dfuw.exe", "Darkfall: Unholy Wars");
		games.put("DCGAME.exe", "DC Universe Online");
		games.put("DeadIslandGame.exe", "Dead Island");
		games.put("deadspace2.exe", "Dead Space 2");
		games.put("LOTDGame.exe", "Deadlight");
		games.put("dxhr.exe", "Deus Ex: Human Revolution");
		games.put("DeviMayCry4.exe", "Devil May Cry 4");
		games.put("DMC-DevilMayCry.exe", "DmC Devil May Cry");
		games.put("dirt2_game.exe", "DiRT 2");
		games.put("dirt3_game.exe", "DiRT 3");
		games.put("dota.exe", "DOTA");
		games.put("DoubleDragon.exe", "Double Dragon Neon");
		games.put("DragonAge2.exe", "Dragon Age II");
		games.put("DragonAgeInquisition.exe", "Dragon Age: Inquisition");
		games.put("daorigins.exe", "Dragon Age: Origins");
		games.put("DBXV.exe", "Dragon Ball XenoVerse");
		games.put("DukeForever.exe", "Duke Nukem Forever");
		games.put("dustforce.exe", "Dustforce");
		games.put("EliteDangerous32.exe", "Elite: Dangerous");
		games.put("exefile.exe", "Eve Online");
		games.put("eqgame.exe", "EverQuest");
		games.put("EverQuest2.exe", "EverQuest II");
		games.put("Engine.exe", "F.E.A.R.");
		games.put("FEAR2.exe", "F.E.A.R. 2: Project Origin");
		games.put("fallout3.exe", "Fallout 3");
		games.put("FalloutNV.exe", "Fallout: New Vegas");
		games.put("farcry3.exe", "Far Cry 3");
		games.put("fifa15.exe", "FIFA 15");
		games.put("FTLGame.exe", "FTL: Faster Than Light");
		games.put("GTAIV.exe", "Grand Theft Auto 4");
		games.put("GTA5.exe", "Grand Theft Auto 5");
		games.put("Gw.exe", "Guild Wars");
		games.put("H1Z1.exe", "H1Z1");
		games.put("HL2HL2.exe", "Half Life 2");
		games.put("HOMEFRONT.exe", "Homefront");
		games.put("invisibleinc.exe", "Invisible Inc.");
		games.put("LANoire.exe", "L.A. Noire");
		games.put("Landmark64.exe", "Landmark");
		games.put("left4dead2.exe", "Left 4 Dead 2");
		games.put("lineage.exe", "Lineage");
		games.put("Magicka.exe", "Magicka");
		games.put("MapleStory.exe", "MapleStory");
		games.put("MassEffect.exe", "Mass Effect");
		games.put("MassEffect2.exe", "Mass Effect 2");
		games.put("MassEffect3Demo.exe", "Mass Effect 3");
		games.put("METAL GEAR RISING REVENGEANCE.exe", "Metal Gear Rising: Revengeance");
		games.put("metro2033.exe", "Metro 2033");
		games.put("MetroLL.exe", "Metro Last Light");
		games.put("MK10.exe", "Mortal Kombat X");
		games.put("speed.exe", "Need For Speed Most Wanted");
		games.put("OLGame.exe", "Outlast");
		games.put("PapersPlease.exe", "Papers, Please");
		games.put("payday_win32_release.exe", "PAYDAY");
		games.put("payday2_win32_release.exe", "PAYDAY2");
		games.put("PillarsOfEternity.exe", "Pillars of Eternity");
		games.put("PA.exe", "Planetary Annihilation");
		games.put("planetside2_x86.exe", "Planetside 2");
		games.put("hl2P.exe", "Portal");
		games.put("portal2.exe", "Portal 2");
		games.put("PrimalCarnageGame.exe", "Primal Cargnage");
		games.put("pCARS.exe", "Project Cars");
		games.put("RaceTheSun.exe", "Race The Sun");
		games.put("Rage.exe", "RAGE");
		games.put("ragexe.exe", "Ragnarok Online");
		games.put("rift.exe", "Rift");
		games.put("Rocksmith2014.exe", "Rocksmith 2014");
		games.put("SwiftKit-RS.exe", "RuneScape");
		games.put("Shadowgrounds.exe", "Shadowgrounds");
		games.put("survivor.exe", "Shadowgrounds: Survivor");
		games.put("ShovelKnight.exe", "Shovel Knight");
		games.put("SimCity.exe", "SimCity");
		games.put("SporeApp.exe", "Spore");
		games.put("StarCitizen.exe", "Star Citizen");
		games.put("battlefront.exe", "Star Wars Battlefront");
		games.put("swtor.exe", "Star Wars: The Old Republic");
		games.put("starbound.exe", "Starbound");
		games.put("starcraft.exe", "Starcraft");
		games.put("SSFIV.exe", "Ultra Street Fighter IV");
		games.put("superhexagon.exe", "Super Hexagon");
		games.put("swordandsworcery_pc.exe", "Superbrothers: Sword & Sworcery EP");
		games.put("hl2TF.exe", "Team Fortress 2");
		games.put("TERA.exe", "TERA");
		games.put("Terraria.exe", "Terraria");
		games.put("Bethesda.net_Launcher.exe", "The Elder Scrolls Online");
		games.put("TESV.exe", "The Elder Scrolls V: Skyrim");
		games.put("TheSecretWorld.exe", "The Secret World");
		games.put("TS3.exe", "The Sims 3");
		games.put("TheWalkingDead2.exe", "The Walking Dead Season Two");
		games.put("witcher3.exe", "The Witcher 3");
		games.put("Future Soldier.exe", "Tom Clancy's Ghost Recon: Future Solider");
		games.put("TombRaider.exe", "Tomb Raider (2013)");
		games.put("Torchlight.exe", "Torchlight");
		games.put("Torchlight2.exe", "Torchlight 2");
		games.put("Shogun2.exe", "Total War: Shogun 2");
		games.put("Transistor.exe", "Transistor");
		games.put("trine.exe", "Trine");
		games.put("trine2_32bit.exe", "Trine 2");
		games.put("UOKR.exe", "Ultima Online");
		games.put("aces.exe", "War Thunder");
		games.put("Warcraft III.exe", "Warcraft 3: Reign of Chaos");
		games.put("Warcraft II BNE.exe", "Warcraft II");
		games.put("Warframe.x64.exe", "Warframe");
		games.put("watch_dogs.exe", "Watch Dogs");
		games.put("WildStar64.exe", "WildStar");
		games.put("XComGame.exe", "XCOM: Enemy Unknown");
		games.put("DFO.exe", "Dungeon Fighter Online");
		games.put("aclauncher.exe", "Asheron's Call");
		games.put("MapleStory2.exe", "MapleStory 2");
		games.put("ksp.exe", "Kerbal Space Program");
		games.put("dave.exe", "Dangerous Dave");
		games.put("iwbtgbeta(slomo).exe", "I Wanna Be The Guy");
		games.put("MechWarriorOnline.exe ", "MechWarrior Online");
		games.put("dontstarve_steam.exe", "Don't Starve");
		games.put("GalCiv3.exe", "Galactic Civilization 3");
		games.put("Risk of Rain.exe", "Risk of Rain");
		games.put("Binding_of_Isaac.exe", "The Binding of Isaac");
		games.put("RustClient.exe", "Rust");
		games.put("Clicker Heroes.exe", "Clicker Heroes");
		games.put("Brawlhalla.exe", "Brawlhalla");
		games.put("TownOfSalem.exe", "Town of Salem");
		games.put("osu!.exe", "osu!");
		games.put("PathOfExileSteam.exe", "Path of Exile");
		games.put("Dolphin.exe", "Dolphin");
		games.put("RocketLeague.exe", "Rocket League");
		games.put("TJPP.exe", "Jackbox Party Pack");
		games.put("KFGame.exe", "Killing Floor 2");
		games.put("ShooterGame.exe", "Ark: Survival Evolved");
		games.put("LifeIsStrange.exe", "Life Is Strange");
		games.put("Client_tos.exe", "Tree of Savior");
		games.put("olliolli2.exe", "OlliOlli2");
		games.put("cw.exe", "Closers Dimension Conflict");
		games.put("ESSTEAM.exe", "Elsword");
		games.put("ori.exe", "Ori and the Blind Forest");
		games.put("Skyforge.exe", "Skyforge");
		games.put("projectzomboid64.exe", "Project Zomboid");
		games.put("From_The_Depths.exe", "From The Depths");
		games.put("TheCrew.exe", "The Crew");
		games.put("MarvelHeroes2015.exe", "Marvel Heroes 2015");
		games.put("timeclickers.exe", "Time Clickers");
		games.put("eurotrucks2.exe", "Euro Truck Simulator 2");
		games.put("FarmingSimulator2015Game.exe", "Farming Simulator 15");
		games.put("strife.exe", "Strife");
		games.put("Awesomenauts.exe", "Awesomenauts");
		games.put("Dofus.exe", "Dofus");
		games.put("Boid.exe", "Boid");
		games.put("adventure-capitalist.exe", "AdVenture Capitalist");
		games.put("OrcsMustDie2.exe", "Orcs Must Die! 2");
		games.put("Mountain.exe", "Mountain");
		games.put("Valkyria.exe", "Valkyria Chronicles");
		games.put("ffxiiiimg.exe", "Final Fantasy XIII");
		games.put("TLR.exe", "The Last Remnant");
		games.put("Cities.exe", "Cities Skylines");
		games.put("worldofwarships.exe", "World of Warships");
		games.put("spacegame-Win64-shipping.exe", "Fractured Space");
		games.put("thespacegame.exe", "Ascent - The Space Game");
		games.put("DuckGame.exe", "Duck Game");
		games.put("PPSSPPWindows.exe", "PPSSPP");
		games.put("MBAA.exe", "Melty Blood Actress Again: Current Code");
		games.put("TheWolfAmongUs.exe", "The Wolf Among Us");
		games.put("SpaceEngineers.exe", "Space Engineers");
		games.put("Borderlands.exe", "Borderlands");
		games.put("100orange.exe", "100% Orange Juice");
		games.put("reflex.exe", "Reflex");
		games.put("pso2.exe", "Phantasy Star Online 2");
		games.put("AssettoCorsa.exe", "Assetto Corsa");
		games.put("iw3mp.exe", "Call of Duty 4: Modern Warfare");
		games.put("WolfOldBlood_x64.exe", "Wolfenstein: The Old Blood");
		games.put("castle.exe", "Castle Crashers");
		games.put("vindictus.exe", "Vindictus");
		games.put("ShooterGame-Win32-Shipping.exe", "Dirty Bomb");
		games.put("BatmanAK.exe", "Batman Arkham Knight");
		games.put("drt.exe", "Dirt Rally");
		games.put("rFactor.exe", "rFactor");
		games.put("clonk.exe", "Clonk Rage");
		games.put("SRHK.exe", "Shadowrun: Hong Kong");
		games.put("Insurgency.exe", "Insurgency");
		games.put("StepMania.exe", "Step Mania");
		games.put("FirefallCLient.exe", "Firefall");
		games.put("mirrorsedge.exe", "Mirrors Edge");
		games.put("MgsGroundZeroes.exe", "Metal Gear Solid V: Ground Zeroes");
		games.put("mgsvtpp.exe", "Metal Gear Solid V: The Phantom Pain");
		games.put("tld.exe", "The Long Dark");
		games.put("TKOM.exe", "Take On Mars");
		games.put("robloxplayerlauncher.exe", "Roblox");
		games.put("eu4.exe", "Europa Universalis 4");
		games.put("APB.exe", "APB Reloaded");
		games.put("Robocraft.exe", "Robocraft");
		games.put("Unity.exe", "Unity");
		games.put("Simpsons.exe", "The Simpsons: Hit & Run");
		games.put("Dnlauncher.exe", "Dragon Nest");
		games.put("Trove.exe", "Trove");
		games.put("EndlessLegend.exe", "Endless Legend");
		games.put("TurbineLauncher.exe", "Dungeons & Dragons Online");
		games.put("quakelive.exe", "Quake Live");
		games.put("7DaysToDie.exe", "7DaysToDie");
		games.put("SpeedRunners.exe", "SpeedRunners");
		games.put("gamemd.exe", "Command & Conquer: Red Alert 2");
		games.put("generals.exe", "Command & Conquer Generals: Zero Hour");
		games.put("Oblivion.exe", "The Elder Scrolls 4: Oblivion");
		games.put("mgsi.exe", "Metal Gear Solid");
		games.put("EoCApp.exe", "Divinity - Original Sin");
		games.put("Torment.exe", "Planescape: Torment");
		games.put("HexPatch.exe", "Hex: Shards of Fate");
		games.put("NS3FB.exe", "Naruto Shippuden Ultimate Ninja Storm 3 Full Burst");
		games.put("NSUNSR.exe", "Naruto Shippuden Ultimate Ninja Storm Revolution");
		games.put("SaintsRowIV.exe", "Saints Row IV");
		games.put("Shadowrun.exe", "Shadowrun");
		games.put("DungeonoftheEndless.exe", "Dungeon of the Endless");
		games.put("Hon.exe", "Heroes of Newerth");
		games.put("Mabinogi.exe", "Mabinogi");
		games.put("CoD2MP_s.exe", "Call of Duty 2:");
		games.put("CoDWaWmp.exe", "Call of Duty: World at War");
		games.put("heroes.exe", "Mabinogi Heroes (Vindictus)  ");
		games.put("KanColleViewer.exe", "KanColle ");
		games.put("cyphers.exe", "Cyphers");
		games.put("RelicCoH2.exe", "Company of Heroes 2");
		games.put("MJ.exe", "??NET??MJ");
		games.put("ge.exe", "Granado Espada");
		games.put("NovaRO.exe", "Nova Ragnarok Online");
		games.put("RivalsofAether.exe", "Rivals of Aether");
		games.put("bfh.exe", "Battlefield Hardline");
		games.put("GrowHome.exe", "Grow Home");
		games.put("patriots.exe", "Rise of Nations Extended");
		games.put("Railroads.exe", "Sid Meier's Railroads!");
		games.put("Empire.exe", "Empire: Total War");
		games.put("Napoleon.exe", "Napoleon: Total War");
		games.put("gta_sa.exe", "Grand Theft Auto: San Andreas");
		games.put("MadMax.exe", "Mad Max");
		games.put("Titanfall.exe", "Titanfall");
		games.put("age2_x1.exe", "Age of Empires II: The Conquerors");
		games.put("Rome2.exe", "Total War: ROME 2");
		games.put("ShadowOfMordor.exe", "Middle-earth: Shadow of Mordor");
		games.put("Subnautica.exe", "Subnautica");
		games.put("anno5.exe", "Anno 2070");
		games.put("carrier.exe", "Carrier Command Gaea Mission");
		games.put("DarksidersPC.exe", "Darksiders");
		games.put("Darksiders2.exe", "Darksiders 2");
		games.put("mudlet.exe", "Mudlet");
		games.put("DunDefLauncher.exe", "Dungeon Defenders II");
		games.put("hng.exe", "Heroes and Generals");
		games.put("WFTOGame.exe", "War For the Overworld");
		games.put("Talisman.exe", "Talisman: Digital Edition");
		games.put("limbo.exe", "Limbo");
		games.put("ibbobb.exe", "ibb & obb");
		games.put("BattleBlockTheater.exe", "BattleBlock Theater");
		games.put("iracinglauncher.exe", "iRacing");
		games.put("CivilizationV_DX11.exe", "Civilization V");
		games.put("lostsaga.exe", "Lost Saga");
		games.put("nuclearthrone.exe", "Nuclear Throne");
		games.put("SwordCoast.exe", "Sword Coast Legends");
		games.put("FF3_Launcher.exe", "Final Fantasy III");
		games.put("UNDERTALE.exe", "Undertale");
		games.put("Blockland.exe", "Blockland");
		games.put("DNF.exe", "Dungeon & Fighter");
		games.put("Bugs.exe", "BBLiT");
		games.put("grid2.exe", "Grid 2");
		games.put("RainbowSix.exe", "Rainbow Six Siege");
		games.put("rotaku.exe", "Rotaku Society");
		games.put("Cube.exe", "Cube World");
		games.put("TS4.exe", "The Sims 4");
		games.put("nekopara_vol1.exe", "Nekopara Vol. 1");
		games.put("nekopara_vol0.exe", "Nekopara Vol. 0");
		games.put("FreeStyle2.exe", "Freestyle Basketball 2");
		games.put("HMA.exe", "Hitman: Absolution");
		games.put("SaintsRowTheThird_DX11.exe", "Saints Row 3");
		games.put("JustCause.exe", "Just Cause");
		games.put("KillingFloor.exe", "Killing Floor");
		games.put("DeadIslandGame_x86_rwdi.exe", "Dead Island Riptide");
		games.put("JustCause2.exe", "Just Cause 2");
		games.put("altitude.exe", "Alltitude");
		games.put("ygopro_vs.exe", "Yu-gi-oh Pro");
		games.put("bejeweled3.exe", "Bejeweled 3");
		games.put("fable.exe", "Fable: The Lost Chapters");
		games.put("lyne.exe", "LYNE");
		games.put("Tabletop Simulator.exe", "Tabletop Simulator");
		games.put("screencheat.exe", "Screencheat");
		games.put("cataclysm-tiles.exe", "Cataclysm: Dark Days Ahead");
		games.put("Prison Architect.exe", "Prison Architect");
		games.put("armoredwarfare.exe", "Armored Warfare");
		games.put("Devilian.exe", "Devilian");
		games.put("Allegiance.exe", "Allegiance");
		games.put("infantry.exe", "Infantry");
		games.put("audiosurf.exe", "Audiosurf");
		games.put("audiosurf2.exe", "Audiosurf 2");
		games.put("morrowind.exe", "Morrowind");
		games.put("GoatGame-Win32-Shipping.exe", "Goat Simulator");
		games.put("th123.exe", "TH12.3 Hisoutensoku");
		games.put("th135.exe", "TH13.5 Hopeless Mascarade");
		games.put("th145.exe", "TH14.5 Urban Legend in Limbo");
		games.put("quake1.exe", "Quake I");
		games.put("quake2.exe", "Quake II");
		games.put("quake3.exe", "Quake III");
		games.put("MONACO.exe", "Monaco: What's Yours Is Mine");
		games.put("ToothAndTail.exe", "Tooth & Tail");
		games.put("PD.exe", "Pixel Dungeon");
		games.put("BlackDesert32.exe", "Black Desert Online");
		games.put("LovelyPlanet.exe", "Lovely Planet");
		games.put("DeadCore.exe", "DeadCore");
		games.put("fifa16.exe", "FIFA 16");
		games.put("KAG.exe", "King Arthur's Gold");
		games.put("TR.exe", "Trench Run");
		games.put("fm.exe", "Football Manager 2014");
		games.put("NecroDancer.exe", "Crypt of the NecroDancer");
		games.put("EthanCarter-Win64-Shipping.exe", "The Vanishing of Ethan Carter Redux");
		games.put("AstronautsGame-Win64-Shipping.exe", "The Vanishing of Ethan Carter");
		games.put("fsx.exe", "Microsoft Flight Simulator X");
		games.put("Prepar3D.exe", "Prepar3D");
		games.put("lumini_Win64.exe", "Lumini");
		games.put("BeatHazard.exe", "Beat Hazard");
		games.put("TribesAscend.exe", "Tribes Ascend");
		games.put("Supernova.exe", "Supernova");
		games.put("NitronicRush.exe", "Nitronic Rush");
		games.put("Might & Magic Heroes VI.exe", "Might & Magic Heroes VI");
		games.put("AdvHD.exe", "If My Heart Had Wings");
		games.put("hatoful.exe", "Hatoful Boyfriend");
		games.put("HuniePop.exe", "HuniePop");
		games.put("SC2VN.exe", "SC2VN: The e-sport Visual Novel");
		games.put("Pyrite Heart.exe", "Pyrite Heart");
		games.put("Sakura Angels.exe", "Sakura Angels");
		games.put("BGI.exe", "Go! Go! Nippon! ~My First Trip to Japan~");
		games.put("Sword of Asumi.exe", "Sword of Asumi");
		games.put("Sakura Clicker.exe", "Sakura Clicker");
		games.put("Sakura Spirit.exe", "Sakura Spirit");
		games.put("NeoAquarium.exe", "NEO AQUARIUM - The King of Crustaceans");
		games.put("Nicole.exe", "Nicole (Otome Version)");
		games.put("LongLiveTheQueen.exe", "Long Live The Queen");
		games.put("The Sacred Tears TRUE.exe", "The Sacred Tears TRUE");
		games.put("trgame.exe", "Tales Runner");
		games.put("CelebrityPoker.exe", "Poker Night at the Inventory");
		games.put("PokerNight2.exe", "Poker Night 2");
		games.put("PokeMMO.exe", "PokeMMO");
		games.put("LoversInADangerousSpacetime.exe", "Lovers in a Dangerous Spacetime");
		games.put("tis100.exe", "TIS-100");
		games.put("TTREngine.exe", "Toontown");
		games.put("mgs2_sse.exe", "Metal Gear Solid 2: Substance");
		games.put("hl.exe", "Half Life");
		games.put("Cloudbuilt.exe", "Cloudbuilt");
		games.put("ACBSP.exe", "Assassin's Creed: Brotherhood");
		games.put("mm.exe", "Dark Messiah of Might & Magic");
		games.put("Stalker-COP.exe", "S.T.A.L.K.E.R.: Call of Pripyat");
		games.put("ROGame.exe", "Rising Storm/Red Orchestra 2");
		games.put("strife-ve.exe", "Strife: Veteran Edition");
		games.put("BFBC2Game.exe", "Battlefield: Bad Company 2");
		games.put("FarCry2.exe", "Far Cry 2");
		games.put("Nidhogg.exe", "Nidhogg");
		games.put("pbbg_win32.exe", "Phantom Break: Baggle Grounds");
		games.put("Wakfu.exe", "Wakfu");
		games.put("wizard101.exe", "Wzard101");
		games.put("BarkleyV120.exe", "Charles Barkley: Shut Up and Jam Gaiden");
		games.put("RimWorld914Win.exe", "RimWorld");
		games.put("Order of Battle - Pacific.exe", "Order of Battle");
		games.put("gh3.exe", "Guitar Hero III: Legends of Rock");
		games.put("phase_shift.exe", "Phase Shift");
		games.put("GHWT.exe", "Guitar Hero World Tour");
		games.put("THEMOD 1.3.exe", "Tony Hawk's Underground 2");
		games.put("THUGPro.exe", "THUG Pro");
		games.put("THUG.exe ", "Tony Hawk's Underground");
		games.put("isaac-ng.exe", "The Binding of Isaac: Rebirth");
		games.put("ProjectG.exe", "PangYa!");
		games.put("overwatch.exe", "Overwatch");
		games.put("CivilizationBE_DX11.exe", "Civilization Beyond Earth");
		games.put("SecretPonchosD3D11.exe", "Secret Ponchos");
		games.put("Duelyst.exe", "Duelyst");
		games.put("Dishonored2.exe", "Dishonored 2");
		games.put("sekiro.exe", "Sekiro Shadows Die Twice");
		games.put("r5apex.exe", "Apex Legends");
		games.put("SlayTheSpire.exe", "Slay the Spire");
		games.put("Cuphead.exe", "Cuphead");
		games.put("WizardOfLegend.exe", "Wizard of Legend");
	}
}

