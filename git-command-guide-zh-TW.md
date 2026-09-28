# Git Command Guide：建立新的 GitHub Repository

![Git 與Github 是什麼？如何使用 Git？｜Ray C的沙龍](https://images.vocus.cc/401e1ad6-a1f9-4104-8235-9cfd636efc6f.png)

流程如下：

1. 安裝 GitHub CLI（`gh`）
2. 在 GitHub 網頁建立空 repository
3. 使用 `gh` 登入並設定 Git credential
4. 將本機專案初始化、提交並推送到 GitHub

> 注意：以下指令中的 `YOUR_USERNAME`、`YOUR_REPO` 和路徑，請替換成自己的資料。

## 1. 安裝 GitHub CLI

### 1.1 先確認 Git 是否已安裝

macOS Terminal、Windows PowerShell 或 Git Bash 都可以執行：

```bash
git --version
```

如果找不到 `git`，請先安裝 Git。課程環境設定文件已有 Git 安裝說明：
[`Enviroment-Setup.md`](../Enviroment-Setup.md)

### 1.2 macOS：使用 Homebrew 安裝

先確認 Homebrew 是否已安裝：

```bash
brew --version
```

如果尚未安裝 Homebrew，請在 Terminal 執行官方安裝指令：

```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

安裝 GitHub CLI：

```bash
brew install gh
gh --version
```

如果 Homebrew 安裝程式要求設定 PATH，請依照 Terminal 顯示的指示完成設定，然後重新開啟 Terminal。

### 1.3 Windows：使用 WinGet 安裝

在 PowerShell 中確認 WinGet 是否可用：

```powershell
winget --version
```

安裝 GitHub CLI：

```powershell
winget install --id GitHub.cli --source winget
```

安裝完成後，關閉並重新開啟 Windows Terminal，再確認：

```powershell
gh --version
```

官方安裝參考：[Installing gh on Windows](https://github.com/cli/cli/blob/trunk/docs/install_windows.md)

## 2. 在 GitHub 網頁建立新的 Repository

1. 登入 [GitHub](https://github.com/)。
2. 點選右上角的 **+**，再選擇 **New repository**。
3. 輸入 repository name，例如 `my-project`。
4. 選擇 **Public** 或 **Private**。
5. 建議不要勾選以下選項，讓 repository 保持空白：
   - Add a README file
   - Add .gitignore
   - Choose a license
6. 點選 **Create repository**。
7. 複製 repository 的 HTTPS URL，例如：

```text
https://github.com/YOUR_USERNAME/YOUR_REPO.git
```

## 3. 使用 `gh` 驗證 GitHub credential

在 Terminal、PowerShell 或 Git Bash 執行：

```bash
gh auth login
```

互動式設定時建議選擇：

1. `GitHub.com`
2. `HTTPS`
3. 使用瀏覽器登入

登入後確認帳號狀態：

```bash
gh auth status
```

讓 Git 使用 GitHub CLI 管理的 credential：

```bash
gh auth setup-git
```

官方參考：[gh auth login](https://cli.github.com/manual/gh_auth_login) 與 [gh auth setup-git](https://cli.github.com/manual/gh_auth_setup-git)

## 4. 將本機專案推送到 GitHub

先切換到本機專案資料夾：

```bash
cd path/to/your-project
```

例如：

```bash
cd ~/Documents/my-project
```

接著依序執行：

### 4.1 初始化 Git repository

```bash
git init
```

### 4.2 將檔案加入 staging area

```bash
git add .
```

檢查目前狀態：

```bash
git status
```

### 4.3 建立第一個 commit

```bash
git commit -m "Initial commit"
```

### 4.4 將主要分支命名為 `main`

```bash
git branch -M main
```

### 4.5 加入遠端 repository

將 `YOUR_REPO_URL` 替換成剛才從 GitHub 複製的 HTTPS URL：

```bash
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO.git
```

確認遠端設定：

```bash
git remote -v
```

### 4.6 第一次推送並設定 upstream

```bash
git push -u origin main
```

`-u` 會將本機的 `main` 設定為追蹤遠端的 `origin/main`。第一次成功推送後，之後通常只需要執行：

```bash
git push
```

## 5. 確認推送結果

可以在瀏覽器開啟 GitHub repository，或使用：

```bash
gh repo view --web
```

也可以確認目前分支與遠端狀態：

```bash
git status
git branch -vv
```

## 6. 日常修改流程

修改檔案後，通常依照以下流程：

```bash
git status
git add .
git commit -m "Describe your changes"
git push
```

取得遠端最新內容：

```bash
git pull
```

查看差異與歷史：

```bash
git diff
git log --oneline
```

## 7. Java 專案建議的 `.gitignore`

如果專案是 Java，可以在專案根目錄建立 `.gitignore`，加入：

```gitignore
*.class
out/
.idea/
.vscode/
.DS_Store
```

`.gitignore` 建議在第一次執行 `git add .` 之前建立。

## 8. 常見問題

### `gh: command not found`

- macOS：確認已執行 `brew install gh`，並重新開啟 Terminal。
- Windows：確認已重新開啟 Windows Terminal，讓 PATH 更新生效。

### 尚未登入 GitHub

```bash
gh auth login
gh auth status
```

### `remote origin already exists`

先查看目前的遠端 URL：

```bash
git remote -v
```

如果需要改成新的 URL：

```bash
git remote set-url origin https://github.com/YOUR_USERNAME/YOUR_REPO.git
```

### 不小心加入不該提交的檔案

在 commit 前，可以將檔案移出 staging area：

```bash
git restore --staged path/to/file
```

### 安全提醒

- 不要將密碼、Personal Access Token、API key 或私人資料提交到 repository。
- 第一次建立遠端 repository 時，應確認 GitHub 網頁上的 repository 是空的。
- 執行 `git push` 前，先用 `git status` 確認目前分支與檔案內容。
