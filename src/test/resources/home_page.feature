Feature: Home page

  Upon entering the blog site, the user shall be presented with an overview of the most recent blog posts.

  Scenario: See overview of blog posts on homepage
    Given there are 5 blog posts available
    When I go to the homepage
    Then I should see the following from the available blog posts
      | name          |
      | description   |
      | creation date |

  Scenario: Only show a given number of blog posts per default
    Given there are 10 blog posts available
    When I go to the homepage
    Then I should only see 5 blog posts
    And I should see the most recently created blog posts

  Scenario: More blog posts can be loaded if they exist
    Given there are 10 blog posts available
    And I should be able to load 5 more blog posts
    And the option to load more should disappear