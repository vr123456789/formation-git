git filter-branch -f --index-filter '
	cp /d/password.txt .
	git add password.txt
' -- HEAD~50..HEAD