package Assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArtistTest {

	@Test
	void testAddArtist_testCase1() {
		Artist ArtistTestCAse1Data1 = new Artist ("657ABCDE!@", "08-08-2002", "Vizag| Andhra Pradesh| India", "I love music and at any cost I will play music", ["Student"], ["2012, Best Singer in Telugu award"], ["melody", "rock"]);	
		Artist ArtistTestCAse1Data2 = new Artist ("798HILKJ%$", "27-04-1970", "Birmingham| Alabama| USA", "I like coffee more than tea, What do you people prefer?", ["Data Scientist", "Professor"], ["1996, The most talented singer of the year", "2002, Best music director in Hollywood"], ["jazz", "rock", "folk"]); 

		assertAll ("", ()->assertEquals(true, ArtistTestCAse1Data1.AddArtist()),
		()->assertEquals (true, ArtistTestCAse1Data2.AddArtist()));
	 
	}
	@Test
	void testAddArtist_testCase2() {
		Artist ArtistTestCAse2Data1 = new Artist ("012HILKJ%$", "02-10-1999", "Birmingham| Alabama| USA", "Ab bc cd de ef fg gh gi ij jk kl", ["Scientist"], ["2007, Singer of the year 2007", "2012, Best Singer in Bollywood award"],  ["jazz"]); 
		Artist ArtistTestCAse2Data2 = new Artist ("5843Lki1#", "17-06-1972", "Birmingham| Alabama| USA", "I like coffee more than tea, What do you people prefer?", ["Data Scientist"], ["2007, Singer of the year 2007"], ["rock", "pop"]); 

		assertAll ("", ()->assertEquals (false, ArtistTestCAse2Data1.AddArtist()),
		()->assertEquals (false, ArtistTestCAse2Data2.AddArtist()));
	}
	
	@Test
	void testAddArtist_testCase3() {
		Artist ArtistTestCAse3Data1 = new Artist ("798HILKJ%$", "27-04-2004", "Birmingham| Alabama| USA", "Hi! all", ["Social media influencer", " student"], [], ["jazz", "rock", "folk"]); 
		Artist ArtistTestCAse3Data2 = new Artist ("798HILKJ%$", "27-04-2004", "Birmingham| Alabama| USA", "H I !  a l l t h I s I s p r a s a d h o w a r e y o u a l l b e s a f e", ["Social media influencer", " student"], ["2007, Singer of the year 2007"], ["jazz", "rock", "folk"]); 
	 
		assertAll ("", ()->assertEquals (false, ArtistTestCAse3Data1.AddArtist()),
		()->assertEquals (false, ArtistTestCAse3Data2.AddArtist()));
	}

	@Test
	void testupdateArtst_testCase4() {
		Artist ArtistTestCAse3Data1 = new Artist ("657ABCDE!@", "08-08-2002", "Vizag| Andhra Pradesh| India", "Hi this is prasad, how are you all? Hope you all are doing well", ["music teacher"], ["2012, Best Male Singer in Telugu award updated"], ["melody", "rock"]); 
		Artist ArtistTestCAse3Data2 = new Artist ("798HILKJ%$", "27-04-1970", "Birmingham| Alabama| USA", "This is an updated bio to check whether the bio can be changed or not", ["Data Scientist", "Professor"], ["1996, The most talented singer of the year", "2002, Best music director in Hollywood 2002"], ["jazz", "rock", "classical"]); 
		 
		assertAll ("", ()->assertEquals (true, ArtistTestCAse3Data1.UpdateArtist()),
		()->assertEquals (true, ArtistTestCAse3Data2.UpdateArtist()));
	}
	@Test
	void testupdateArtst_testCase5() {
		Artist ArtistTestCAse3Data1 = new Artist ("798HILKJ%$", "27-04-1970", "Birmingham| Alabama| USA", "I like coffee more than tea, What do you people prefer?", ["Scientist", "Professor"], ["1996, The most talented singer of the year", "2002, Best music director in Hollywood 2002"], ["jazz", "rock", "folk"]);
		Artist ArtistTestCAse3Data2 = new Artist ("798HILKJ%$", "27-04-1970", "Birmingham| Alabama| USA", "I like coffee more than tea, What do you people prefer?", ["Scientist", "Teacher"], ["1996, The most talented singer of the year", "2002, Best music director in Hollywood 2002"], ["jazz", "rock", "folk"]);
		 
		assertAll ("", ()->assertEquals (false, ArtistTestCAse3Data1.UpdateArtist()),
		()->assertEquals (false, ArtistTestCAse3Data2.UpdateArtist()));
	}
	
	@Test
	void testupdateArtst_testCase6() {
		Artist ArtistTestCAse3Data1 = new Artist ("798HILKJ%$", "27-04-1970", "Birmingham| Alabama| USA", "I like coffee more than tea, What do you people prefer?", ["Data Scientist"], ["1997, The most talented singer of the year", "2002, Best music director in Hollywood 2002 updated"], ["jazz", "rock", "folk"]);
		Artist ArtistTestCAse3Data2 = new Artist ("798HILKJ%$", "27-04-1970", "Birmingham| Alabama| USA", "I like coffee more than tea, What do you people prefer?", ["Data Scientist"], ["1996, The most talented singer of the year updated", "2002, Best music director in Hollywood 2002"], ["jazz", "rock", "folk"]);

		assertAll ("", ()->assertEquals (false, ArtistTestCAse3Data1.UpdateArtist()),
		()->assertEquals (false, ArtistTestCAse3Data2.UpdateArtist()));
	}
}