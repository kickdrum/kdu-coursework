# kdu-coursework
A repo having skeleton of all KDU assignments, homework and assessment submissions.

## Instructions for repo setup
- Fork this repo from your own account - check the `Copy the main branch only` checkbox.
- Go to Settings 
- Scroll down to the `Security` section in the left panel.
- Select `Secrets and Variables` -> `Actions`.
- Click on `New repository secret` and create the following 6 secrets.

 | Name | Secret Value |
 | ------- | ----------- |
 | KDUER_NAME | (your name) |
 | PERSONAL_ACCESS_TOKEN_GITHUB | <Follow steps in https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens#creating-a-fine-grained-personal-access-token to create a fine grained Github access token. Make sure you give the token `Read and Write` access to Issues and Pull requests.> |
 | REPO_NAME_GITHUB | (Name of the repo, in this case - kdu-coursework) |
 | SONAR_HOST_URL | (Sonar host URL provided on Slack) |
 | SONAR_TOKEN | (Sonar token provided on Slack) |
 | USERNAME_GITHUB | (your Github username) |

## Instructions for submitting homework(exercise), assessments or assignments
For both the Backend and frontend tracks, you'll have 3 assignments, 2 assessments and close to ~20 homeworks to be submitted.

For any homework(exercise) or assessment or assignment Pull Request that you create, follow the below guidelines:

- Create a new branch named `homework-<homework-no>` for homeworks, `assessment-<homework-no>` for assessments or `assignment-<homework-no>` for assignments (whichever is the case), which is based out of origin/main. example, `homework-1`, `homework-2`, etc.
   Command - `git checkout -b homework-<homework-no>`
- Use the respective numbered folders in this repo to commit your code. For example, for submitting the first homework for the Backend track, use the folder `/backend/homework/1`. Similarly, for Backend assessments, use the folder, `/backend/assessments/<assessment number>` and for assignments, use `/backend/assessments/<assessment number>`. Same goes for frontend.
- Always have a README.md and .gitignore files in the same directory explaining your work.
- Before committing the code, copy over the appropriate Github action workflows for your respective homework/assessment/assignment from the `.github/all-workflows` folder to the `.github/workflows` folder. For example, for submitting the first homework for the Backend track, copy over the files from  `.github/all-workflows/backend/homework/1` to `.github/workflows` folder. And, for submitting the second homework, remove the file(s) added as part of homework 1 from `.github/workflows` and add the file(s) from `.github/all-workflows/backend/homework/2` to `.github/workflows`. Similarly follow this for all homeworks, assignments and assessments.
- Submit a pull request(PR) to main branch - add your track assists and track leads as reviewers to the PR.
- On the pull request, make sure your Github actions passes and then, based on the comment created by your Sonar analysis or functional test Github actions, login to the SonarQube instance and check/fix your code smells, vulnerabilities, bugs, etc or fix your functional test case failures, if any, and re-push your changes to the PR.
#
## Instructions for maven-based backend homeworks, assessments and assignments
- add the following code block below the `dependencies` section of your parent pom.xml
```
<build>
    <pluginManagement>
        <plugins>
            <plugin>
                <groupId>org.sonarsource.scanner.maven</groupId>
                <artifactId>sonar-maven-plugin</artifactId>
                <version>3.10.0.2594</version>
            </plugin>
        </plugins>
    </pluginManagement>
</build>
```
