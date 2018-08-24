git filter-branch -f --tree-filter '
	token='eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRldXIiOiJSb21haW4gV2FybmFuIiwiZGVzY3JpcHRpb24iOiJCaWVuIGpvdcOpIHBldGl0IG1hbGluICEiLCJzbWlsZXkiOiLwn5iGIiwiZXhjdXNlcyI6IkTDqXNvbMOpLCBvbiBz4oCZYW11c2UgY29tbWUgb24gcGV1dOKApiJ9.1qbKErZhbxR8u-9QJV3OjAXDyQcn7VVR1LQKiENH4mo'
	sed "2iapplication.secret.token=$token" src/main/resources/application.properties > .tmp-filter
	mv .tmp-filter src/main/resources/application.properties
' -- HEAD~65..HEAD