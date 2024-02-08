package com.movie.aggregator.domain;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.movie.aggregator.common.ImageUtils;


/**
 * @author Angelia Aju Mathai
 */


@Entity
@Table(name = "movies")
public class Movies {
	
	private static final String TMDB_IMAGE_BASE_URL = "https://image.tmdb.org/t/p/original";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "releaseYear")
    private int releaseYear;

    @Column(name = "genreId")
    private int genreId;

    @Column(name = "languageId")
    private int languageId;

    @Column(name = "story")
    @Lob
    private String story;

    @Column(name = "createdBy")
    private int createdBy;

    @Column(name = "createdTimestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTimestamp;

    @Column(name = "lastUpdtTimestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdtTimestamp;

    @Column(name = "active", length = 1)
    private String active;

    @Column(name = "base64Img", columnDefinition = "varchar(MAX)")
    private String base64Img;
    
    private String posterPath;
    
    public Movies() {}

    /*public Movies(int id, String name, int releaseYear, int genreId, int languageId, String story, int createdBy,
			Date createdTimestamp, Date lastUpdtTimestamp, String active, String base64Img, String posterPath,
			Boolean adult, String overview, String releaseDate, String originalTitle, String originalLanguage,
			String title, String backdropPath, Double popularity, Integer voteCount, Boolean video,
			Integer voteAverage) {
		super();
		this.id = id;
		this.name = name;
		this.releaseYear = releaseYear;
		this.genreId = genreId;
		this.languageId = languageId;
		this.story = story;
		this.createdBy = createdBy;
		this.createdTimestamp = createdTimestamp;
		this.lastUpdtTimestamp = lastUpdtTimestamp;
		this.active = active;
		this.base64Img = base64Img;
		this.posterPath = posterPath;
		this.adult = adult;
		this.overview = overview;
		this.releaseDate = releaseDate;
		this.originalTitle = originalTitle;
		this.originalLanguage = originalLanguage;
		this.title = title;
		this.backdropPath = backdropPath;
		this.popularity = popularity;
		this.voteCount = voteCount;
		this.video = video;
		this.voteAverage = voteAverage;
	}*/

	public Movies(String posterPath, Boolean adult, String overview, String releaseDate, Integer id, String originalTitle, String originalLanguage, String title, String backdropPath, Double popularity, Integer voteCount, Boolean video, Integer voteAverage) throws Exception {
        //Handling poster image
		String imgPath=TMDB_IMAGE_BASE_URL + posterPath;
		String base64Image =null;
		if(posterPath!=null && imgPath != null)
		  base64Image = ImageUtils.imageToBase64String(imgPath);
		
		this.base64Img = base64Image;
		this.posterPath=posterPath;
        this.adult = adult;
        //Handled Plot
        this.story = overview;
        LocalDate date = LocalDate.parse(releaseDate);
        // Extract the year from the LocalDate object
        int year = date.getYear();
        //Handled Year
        this.releaseYear = year;
        this.id = id;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        //Handled name
        this.name = title;
        this.backdropPath = backdropPath;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.video = video;
        this.voteAverage = voteAverage;
    }

	@Override
	public String toString() {
		return "Movies [id=" + id + ", name=" + name + ", releaseYear=" + releaseYear + ", genreId=" + genreId
				+ ", languageId=" + languageId + ", story=" + story + ", createdBy=" + createdBy + ", createdTimestamp="
				+ createdTimestamp + ", lastUpdtTimestamp=" + lastUpdtTimestamp + ", active=" + active + ", base64Img="
				+ base64Img + ", posterPath=" + posterPath + ", adult=" + adult + ", overview=" + overview
				+ ", releaseDate=" + releaseDate + ", originalTitle=" + originalTitle + ", originalLanguage="
				+ originalLanguage + ", title=" + title + ", backdropPath=" + backdropPath + ", popularity="
				+ popularity + ", voteCount=" + voteCount + ", video=" + video + ", voteAverage=" + voteAverage + "]";
	}

	private Boolean adult;

    @Lob
    private String overview;

    private String releaseDate;


    private String originalTitle;

    private String originalLanguage;

    private String title;

    private String backdropPath;

    private Double popularity;

    private Integer voteCount;

    private Boolean video;

    private Integer voteAverage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Date getLastUpdtTimestamp() {
		return lastUpdtTimestamp;
	}

	public void setLastUpdtTimestamp(Date lastUpdtTimestamp) {
		this.lastUpdtTimestamp = lastUpdtTimestamp;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getBase64Img() {
		return base64Img;
	}

	public void setBase64Img(String base64Img) {
		this.base64Img = base64Img;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public Boolean getAdult() {
		return adult;
	}

	public void setAdult(Boolean adult) {
		this.adult = adult;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	public Double getPopularity() {
		return popularity;
	}

	public void setPopularity(Double popularity) {
		this.popularity = popularity;
	}

	public Integer getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}

	public Boolean getVideo() {
		return video;
	}

	public void setVideo(Boolean video) {
		this.video = video;
	}

	public Integer getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(Integer voteAverage) {
		this.voteAverage = voteAverage;
	}
    

}

