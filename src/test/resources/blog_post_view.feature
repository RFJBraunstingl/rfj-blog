Feature: Blog post view

  In order to read a blog post
  As a user
  I want to be redirected to a page displaying all the content of a blog post when selecting it on the home page.

  By selecting a blog post from the home page, the user is directed to a page where they can read the post and be
  presented with related posts.

  Scenario: Redirecting user on post selection
    Given there are available blog posts
    When I go to the homepage
    And I select a blog post
    Then I should be directed to a site where I can view the blog post in more detail

  Scenario: Blog post details
    When I am directed to the blog post page
    Then I should see the following from the selected blog post:
      | name          |
      | creation date |
      | text          |