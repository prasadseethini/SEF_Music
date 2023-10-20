package Assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Artist {
    private String Artist_ID;
    private String DOB;
    private String Address;
    private String Bio;
    private ArrayList<String> Occupations;
    private ArrayList<String> Awards;
    private ArrayList<String> Genres;

    public Artist(String Artist_ID, String DOB, String Address, String Bio,
                  ArrayList<String> Occupations, ArrayList<String> Awards, ArrayList<String> Genres) {
        this.Artist_ID = Artist_ID;
        this.DOB = DOB;
        this.Address = Address;
        this.Bio = Bio;
        this.Occupations = Occupations;
        this.Awards = Awards;
        this.Genres = Genres;
    }
    public boolean AddArtist(String Artist_ID, String DOB, String Address, String Bio,
    ArrayList<String> Occupations, ArrayList<String> Awards, ArrayList<String> Genres) {
     
        if (!Check_Artist_ID(Artist_ID)) {
            return false;
        }

        if (!Check_DOB(DOB)) {
            return false;
        }

        if (!Check_Address(Address)) {
            return false;
        }

        if (!Check_Bio(Bio)) {
            return false;
        }

        if (!Check_Occupations(Occupations)) {
            return false;
        }

        if (!Check_Awards(Awards)) {
            return false;
        }

        if (!Check_Genres(Genres)) {
            return false;
        }

        writeArtistToFile();

        return true;
    }


    private boolean Check_Artist_ID(String artist_ID2) {
		return false;
	}
	public boolean UpdateArtist(Artist updatedArtist) {
        if (!Check_Artist_ID(updatedArtist.Artist_ID) ||
            !Check_DOB(updatedArtist.DOB) ||
            !Check_Address(updatedArtist.Address) ||
            !Check_Bio(updatedArtist.Bio) ||
            !Check_Occupations(updatedArtist.Occupations) ||
            !Check_Awards(updatedArtist.Awards) ||
            !Check_Genres(updatedArtist.Genres)) {
            return false;
        }

        String[] DOBParts = DOB.split("-");
        int birthYear = Integer.parseInt(DOBParts[2]);
        if (birthYear < 2000 && !Occupations.equals(updatedArtist.Occupations)) {
            return false;
        }

        if (!Check_AwardUpdates(updatedArtist.Awards)) {
            return false;
        }
        updateArtistInFile(updatedArtist);

        return true;
    }


    private void writeArtistToFile() {
        String fileName = "artists.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(Artist_ID + "," + DOB + "," + Address + "," + Bio + "," +
                    String.join("|", Occupations) + "," + String.join("|", Awards) + "," + String.join(",", Genres));
            writer.newLine();
            writer.close();
            System.out.println("Artist information added successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file '" + fileName + "'");
        }
    }
    
    private void updateArtistInFile(Artist updatedArtist) {
        String fileName = "artists.txt";
        String tempFileName = "temp_artists.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(Artist_ID)) {
                    writer.write(updatedArtist.Artist_ID + "," + updatedArtist.DOB + "," + updatedArtist.Address
                            + "," + updatedArtist.Bio + "," + String.join("|", updatedArtist.Occupations) + ","
                            + String.join("|", updatedArtist.Awards) + "," + String.join(",", updatedArtist.Genres));
                } else {
                    writer.write(line);
                }
                writer.newLine();
            }
            reader.close();
            writer.close();
            File originalFile = new File(fileName);
            if (originalFile.delete()) {
                File newFile = new File(tempFileName);
                if (newFile.renameTo(originalFile)) {
                    System.out.println("Artist information updated successfully.");
                } else {
                    System.out.println("Error updating artist information.");
                }
            } else {
                System.out.println("Error updating artist information.");
            }
        } catch (IOException e) {
            System.out.println("Error updating artist information.");
        }
    }
    
    
    public boolean validArtist_ID(String Artist_ID) {
        if (Artist_ID.length() != 10) {
            return false;
        }

        String numericPart = Artist_ID.substring(0, 3);

        int numericValue;
        try {
            numericValue = Integer.parseInt(numericPart);
        } catch (NumberFormatException e) {
            return false; 
        }
        if (numericValue < 555 || numericValue > 999) {
            return false;
        }
        String letterPart = Artist_ID.substring(3, 8);
        if (!isAllUpperCaseLetters(letterPart)) {
            return false;
        }
        char charBeforeLast = Artist_ID.charAt(8);
        char lastChar = Artist_ID.charAt(9);
        if (Character.isLetterOrDigit(charBeforeLast) || Character.isLetterOrDigit(lastChar)) {
            return false;
        }
    
        return true;
    }
    
    
    private boolean isAllUpperCaseLetters(String letterPart) {
		return false;
	}
	public boolean Check_DOB(String DOB) {
        String[] dateComponents = DOB.split("-");
        if (dateComponents.length != 3) {
            return false; 
        }

        int day, month, year;
        try {
            day = Integer.parseInt(dateComponents[0]);
            month = Integer.parseInt(dateComponents[1]);
            year = Integer.parseInt(dateComponents[2]);
        } catch (NumberFormatException e) {
            return false;
        }

        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900 || year > 9999) {
            return false;
        }
    

        return true;
    }
    
    
    private boolean Check_Address(String Address) {
        if (Address.split("\\|").length != 3) {
            return false;
        }
        return true;
    }
    
    private boolean Check_Bio(String Bio) {
        int wordCount = Bio.split("\\s+").length;
        return wordCount >= 10 && wordCount <= 30;
    }
    
    private boolean Check_Occupations(ArrayList<String> Occupations) {
        return Occupations.size() >= 1 && Occupations.size() <= 5;
    }
    
    private boolean Check_Awards(ArrayList<String> Awards) {
        for (String award : Awards) {
            String[] awardParts = award.split(", ");
            if (awardParts.length != 2) {
                return false;
            }
            String awardYear = awardParts[0];
            String awardTitle = awardParts[1];
            if (!awardYear.matches("^\\d{4}$") || (awardTitle.length() < 4 || awardTitle.length() > 10)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean Check_Genres(ArrayList<String> Genres) {
        if (Genres.size() < 2 || Genres.size() > 5) {
            return false;
        }
        if (Genres.contains("pop") && Genres.contains("rock"));{
            return false;
        }
    }
    
    private boolean Check_AwardUpdates(ArrayList<String> updatedAwards) {
        for (String updatedAward : updatedAwards) {
            String[] awardParts = updatedAward.split(", ");
            if (awardParts.length != 2) {
                return false;
            }
            String awardYear = awardParts[0];
            String awardTitle = awardParts[1];
            if (!awardYear.matches("^\\d{4}$") || (awardTitle.length() < 4 || awardTitle.length() > 10)) {
                return false;
            }
        }
        return true;
    }
}
    


