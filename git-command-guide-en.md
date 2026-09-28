# Git Command Guide: Creating a New GitHub Repository

This guide shows how to turn a local project into a new GitHub repository on macOS or Windows.

The workflow is:

1. Install GitHub CLI (`gh`)
2. Create an empty repository on GitHub's website
3. Log in with `gh` and configure Git credentials
4. Initialize, commit, and push the local project to GitHub

> Note: Replace `YOUR_USERNAME`, `YOUR_REPO`, and the paths in the commands with your own values.

## 1. Install GitHub CLI

### 1.1 Check whether Git is installed

Run the following command in macOS Terminal, Windows PowerShell, or Git Bash:

```bash
git --version
```

If `git` is not found, install Git first. The course environment setup guide includes Git installation instructions:
[`Enviroment-Setup.md`](../Enviroment-Setup.md)

### 1.2 macOS: Install with Homebrew

First check whether Homebrew is installed:

```bash
brew --version
```

If Homebrew is not installed, run the official installation command in Terminal:

```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

Install GitHub CLI:

```bash
brew install gh
gh --version
```

If the Homebrew installer asks you to configure PATH, follow the instructions shown in Terminal and then reopen Terminal.

### 1.3 Windows: Install with WinGet

Check whether WinGet is available in PowerShell:

```powershell
winget --version
```

Install GitHub CLI:

```powershell
winget install --id GitHub.cli --source winget
```

After installation, close and reopen Windows Terminal, then verify the installation:

```powershell
gh --version
```

Official installation reference: [Installing gh on Windows](https://github.com/cli/cli/blob/trunk/docs/install_windows.md)

## 2. Create a New Repository on GitHub's Website

1. Sign in to [GitHub](https://github.com/).
2. Click **+** in the upper-right corner and select **New repository**.
3. Enter a repository name, such as `my-project`.
4. Choose **Public** or **Private**.
5. Leave the following options unchecked so that the repository remains empty:
   - Add a README file
   - Add .gitignore
   - Choose a license
6. Click **Create repository**.
7. Copy the repository's HTTPS URL, for example:

```text
https://github.com/YOUR_USERNAME/YOUR_REPO.git
```

## 3. Authenticate GitHub Credentials with `gh`

Run the following command in Terminal, PowerShell, or Git Bash:

```bash
gh auth login
```

For the interactive setup, select:

1. `GitHub.com`
2. `HTTPS`
3. Sign in using a web browser

Check the authentication status:

```bash
gh auth status
```

Configure Git to use GitHub CLI to manage credentials:

```bash
gh auth setup-git
```

Official references: [gh auth login](https://cli.github.com/manual/gh_auth_login) and [gh auth setup-git](https://cli.github.com/manual/gh_auth_setup-git)

## 4. Push the Local Project to GitHub

First, switch to the local project directory:

```bash
cd path/to/your-project
```

For example:

```bash
cd ~/Documents/my-project
```

Then run the following commands in order.

### 4.1 Initialize the Git repository

```bash
git init
```

### 4.2 Add files to the staging area

```bash
git add .
```

Check the current status:

```bash
git status
```

### 4.3 Create the first commit

```bash
git commit -m "Initial commit"
```

### 4.4 Rename the main branch to `main`

```bash
git branch -M main
```

### 4.5 Add the remote repository

Replace the URL below with the HTTPS URL copied from GitHub:

```bash
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO.git
```

Verify the remote configuration:

```bash
git remote -v
```

### 4.6 Push for the first time and set the upstream branch

```bash
git push -u origin main
```

`-u` configures the local `main` branch to track the remote `origin/main` branch. After the first successful push, you usually only need:

```bash
git push
```

## 5. Verify the Push

Open the GitHub repository in a browser, or run:

```bash
gh repo view --web
```

You can also check the current branch and remote tracking status:

```bash
git status
git branch -vv
```

## 6. Daily Git Workflow

After modifying files, the usual workflow is:

```bash
git status
git add .
git commit -m "Describe your changes"
git push
```

Download the latest changes from the remote repository:

```bash
git pull
```

View changes and commit history:

```bash
git diff
git log --oneline
```

## 7. Recommended `.gitignore` for Java Projects

For a Java project, create a `.gitignore` file in the project root and add:

```gitignore
*.class
out/
.idea/
.vscode/
.DS_Store
```

Create `.gitignore` before running `git add .` for the first time.

## 8. Common Problems

### `gh: command not found`

- macOS: Make sure `brew install gh` has been run, then reopen Terminal.
- Windows: Reopen Windows Terminal so that the updated PATH takes effect.

### Not logged in to GitHub

```bash
gh auth login
gh auth status
```

### `remote origin already exists`

First check the current remote URL:

```bash
git remote -v
```

To change it to a new URL:

```bash
git remote set-url origin https://github.com/YOUR_USERNAME/YOUR_REPO.git
```

### Added the wrong file by accident

Before committing, remove a file from the staging area with:

```bash
git restore --staged path/to/file
```

### Security reminders

- Do not commit passwords, Personal Access Tokens, API keys, or private information.
- Make sure the GitHub repository is empty when connecting it to an existing local project for the first time.
- Run `git status` before `git push` to confirm the current branch and file changes.
