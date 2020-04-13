package dev.rfj.blog.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomepageSteps {

    @Given("there are {int} blog posts available")
    public void thereAreNBlogPostsAvailable(int numOfBlogPosts) {
    }

    @When("I go to the homepage")
    public void iGoToTheHomepage() {
    }

    @Then("I should see the following from the available blog posts")
    public void iShouldSeeTheFollowingFromTheAvailableBlogPosts() {
    }
}
