Feature: Accessibility Tests

  @AxeTest
  Scenario Outline: TC01-PrintResultsOfWebContentAccessibilityGuidelines
    Given Launch the "<Browser>" and navigate to "<URL>" to validate the Conformance Tag "<ConformanceTag>"
    Then find and print the number of passed items at "<ResultPath>"
    And find and print the number of violation items at "<ResultPath>"
    And find and print the number of review items at "<ResultPath>"
    And find and print the number of inapplicable items at "<ResultPath>"

    Examples: 
      | Browser | URL                          | ConformanceTag | ResultPath |
      | Chrome  | https://www.mysynchrony.com/ | wcag2a         | HomePage1  |
      | Chrome  | https://www.mysynchrony.com/ | wcag2aa        | HomePage2  |
      | Chrome  | https://www.mysynchrony.com/ | wcag2aaa       | HomePage3  |
      | Chrome  | https://www.mysynchrony.com/ | best-practice  | HomePage4  |
      | Chrome  | https://www.mysynchrony.com/ | All            | HomePage5  |

  #@AxeTest
  #Scenario Outline: TC02-PrintResultsOfWebContentAccessibilityGuidelines
  #Given Launch the "<Browser>" and navigate to "<URL>" to validate the Conformance Tag "<ConformanceTag>"
  #Then find and print the number of passed items at "<ResultPath>"
  #And find and print the number of violation items at "<ResultPath>"
  #And find and print the number of review items at "<ResultPath>"
  #And find and print the number of inapplicable items at "<ResultPath>"
  #Examples:
  #| Browser | URL                                           | ConformanceTag | ResultPath    |
  #| Chrome  | https://www.mysynchrony.com/how-it-works.html | wcag2a         | WorkHomePage1 |
  #| Chrome  | https://www.mysynchrony.com/how-it-works.html | wcag2aa        | WorkHomePage2 |
  #| Chrome  | https://www.mysynchrony.com/how-it-works.html | wcag2aaa       | WorkHomePage3 |
  #| Chrome  | https://www.mysynchrony.com/how-it-works.html | best-practice  | WorkHomePage4 |
  #| Chrome  | https://www.mysynchrony.com/how-it-works.html | All            | WorkHomePage5 |
  
  @AxeTest
  Scenario Outline: TC03-PrintResultsOfWebContentAccessibilityGuidelines
    Given Launch the "<Browser>" and navigate to "<URL>" to validate the Conformance Tag "<ConformanceTag>"
    Then find and print the number of passed items at "<ResultPath>"
    And find and print the number of violation items at "<ResultPath>"
    And find and print the number of review items at "<ResultPath>"
    And find and print the number of inapplicable items at "<ResultPath>"

    Examples: 
      | Browser | URL                               | ConformanceTag | ResultPath      |
      | Chrome  | https://stackoverflow.com/company | wcag2a         | SomeotherSites1 |
      | Chrome  | https://stackoverflow.com/company | wcag2aa        | SomeotherSites2 |
      | Chrome  | https://stackoverflow.com/company | wcag2aaa       | SomeotherSites3 |
      | Chrome  | https://stackoverflow.com/company | best-practice  | SomeotherSites4 |
      | Chrome  | https://stackoverflow.com/company | All            | SomeotherSites5 |
