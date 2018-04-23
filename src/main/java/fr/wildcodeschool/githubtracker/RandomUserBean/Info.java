package fr.wildcodeschool.githubtracker.RandomUserBean;

public class Info {
    private String seed;
    private float results;
    private float page;
    private String version;


    // Getter Methods

    public String getSeed() {
        return seed;
    }

    public float getResults() {
        return results;
    }

    public float getPage() {
        return page;
    }

    public String getVersion() {
        return version;
    }

    // Setter Methods

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public void setResults(float results) {
        this.results = results;
    }

    public void setPage(float page) {
        this.page = page;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}