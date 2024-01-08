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
 | KDUER_NAME | <your name> |
 | PERSONAL_ACCESS_TOKEN_GITHUB | <Follow steps in https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens#creating-a-fine-grained-personal-access-token to create a fine grained Github access token. Make sure you give the token `Read and Write` access to Issues and Pull requests.> |
 | REPO_NAME_GITHUB | <Name of the repo, in this case - kdu-coursework> |
 | SONAR_HOST_URL | <Sonar host URL provided on Slack> |
 | SONAR_TOKEN | <Sonar token provided on Slack> |
 | USERNAME_GITHUB | <your Github username> |


