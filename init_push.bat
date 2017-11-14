cd /d "%~dp0"
git init
git add *
git commit -a -m "version initiale"
git remote add gitHubOriginAfcepfsoapEjb https://didier-tp:pwd007!@github.com/didier-tp/afcepf_soapEjb.git
git push -u gitHubOriginAfcepfsoapEjb master
pause

REM open with text editor
REM opne with system editor