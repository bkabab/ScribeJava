This is the UAT for Scribe Java.
It consists of src files, test cases, and snapshots of the code coverage using EclEmma tool. 

----------------------------------------------------------------------------------------------------------------------------------------------------------------

Tests performed:

(i) The first test conducted was to check if the request token was obtained properly
Observation: The request token was obtained successfully in all tested cases

(ii) Next the Scribe Authorization from the user was required. This required the user to manually go to the specified URL and obtain the verification code.
Observation: The verification code when entered correctly yielded the access token in all cases tested. 
If the entered verification code was false/incorrect, it would result in a failure to obtain the access token.

(iii) Once the access token was obtained, the final step was to ensure that the API call was made and consequently obtain a resource from the API.
Observation: A protected resource was obtained in each case tested and the OAuth authorization was completed successfully.

----------------------------------------------------------------------------------------------------------------------------------------------------------------


The code coverage shows the total % of coverage as a function of number of lines of code covered by tests.

We can see from the coverage report that, the source files have a 97.6 % coverage.
Covered instructions = 723
Missed instructions = 18
Total instructions = 741

The test files have a coverage of 100 %

Covered instructions = 36
Missed instructions = 0
Total instructions = 36

Overall, the entire Scribe project has a coverage of 97.7 %

Covered instructions = 759
Missed instructions = 18
Total instructions = 777