package followYourGenes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class ExportationFyg {
	public static void saveTree(Tree t) throws IOException {
		try{
			FileWriter write1 = new FileWriter("savedTree/tree.fyg");
			BufferedWriter writer1 = new BufferedWriter(write1);
			writer1.write(".H");
			writer1.newLine();
			writer1.write("="+t.getNom());
			writer1.newLine();
			writer1.write("=fyg0.1");
			writer1.newLine();
			writer1.write("@");
			writer1.newLine();
			writer1.write(".M");
			writer1.newLine();
			int size = t.getMembres().size();
			for(int i=0;i<size;i++) {
				if(t.getMembres().get(i) != null){
					//String name, String firstName, String birthPlace, LocalDate birthDate, String deathPlace, LocalDate deathDate, TypeSex sex, int id
					writer1.write("="+t.getMembres().get(i).getName()+","+t.getMembres().get(i).getFirstName()+","+t.getMembres().get(i).getBirthPlace()+","+t.getMembres().get(i).getBirthDate()+","+t.getMembres().get(i).getDeathPlace()+","+t.getMembres().get(i).getDeathDate()+","+t.getMembres().get(i).getSex()+","+t.getMembres().get(i).getId()+","+t.getMembres().get(i).getComment());
					writer1.newLine();
				}
				else
					size++;
			}
			writer1.write("@");
			writer1.newLine();
			writer1.write(".L");
			writer1.newLine();
			writer1.write(":C");
			writer1.newLine();
			for(int i=0;i<t.getLinks().size();i++) {
				if(t.getLinks().get(i) instanceof LinkH) {
					writer1.write("="+t.getLinks().get(i).getId1()+","+t.getLinks().get(i).getId2()+","+t.getLinks().get(i).getTypeLink());
					writer1.newLine();
				}
			}
			writer1.write(":A");
			writer1.newLine();
			for(int i=0;i<t.getLinks().size();i++) {
				if(t.getLinks().get(i) instanceof LinkV) {
					writer1.write("="+t.getLinks().get(i).getId1()+","+t.getLinks().get(i).getId2());
					writer1.newLine();
				}
			}
			writer1.write("@");
			
			writer1.close();
			write1.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void loadTree(Tree t) throws IOException {
		String treeName = t.getNom();
		t = new Tree(treeName);
		String part = "@";
		String part2 = "@";
		try{
			FileReader read = new FileReader("savedTree/tree.fyg");
			BufferedReader reader = new BufferedReader(read);
			while(reader.ready()) //lit ligne par ligne le fichier
			{
				String line = reader.readLine(); //stock dans variable line la ligne actuelle
				switch(line){
					case ".M" : part = ".M"; break;
					case ".L" : part = ".L"; break;
				}
				if(part == ".M") {
					if(line.contains("=")) {
						line = line.substring(1);
						String [] personne;
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						personne = line.split(",");
						String name = null;
						if(!"null".equals(personne[0]))
							name = personne[0];
						String firstName = null;
						if(!"null".equals(personne[1]))
							firstName = personne[1];
						String birthPlace = null;
						if(!"null".equals(personne[2]))
							birthPlace = personne[2];
						LocalDate birthDate = null;
						if(!"null".equals(personne[3]))
							birthDate = LocalDate.parse(personne[3], formatter);
						String deathPlace = null;
						if(!"null".equals(personne[4]))
							deathPlace = personne[4];
						LocalDate deathDate = null;
						if(!"null".equals(personne[5]))
							deathDate = LocalDate.parse(personne[5], formatter);
						String comment = null;
						if(!"null".equals(personne[8]))
							comment = personne[8];
						t.ajouterPersonne(name, firstName, birthPlace, birthDate, deathPlace, deathDate, t.getTypeSex(personne[6]), Integer.parseInt(personne[7]), comment);
					}
				}
				if(part == ".L") {
					switch(line){
						case ":C" : part2 = ":C"; break;
						case ":A" : part2 = ":A"; break;
					}
					if(part2 == ":C") {
						if(line.contains("=")) {
							line = line.substring(1);
							String [] lien;
							lien = line.split(",");
							t.creerLienH(Integer.parseInt(lien[0]), Integer.parseInt(lien[1]), TypeLinkUnion.valueOf(lien[2]));
						}
					}
				}
			}
			reader.close(); //on ferme le buffered reader
			read.close(); //on ferme le fichier
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
