#!/usr/bin/bash

echo "Réinitialisation"
git checkout tp6
git reset --hard debut-tp6

echo "2 commits dans 'tp6'"
git am --signoff patches/0001-*.patch
git am --signoff patches/0002-*.patch

echo "1 commit dans 'email-regex'"
git branch -D email-regex
git checkout -b email-regex
git am --signoff patches/0003-*.patch

echo "3 commits dans tp6"
git checkout tp6
git am --signoff patches/0004-*.patch
git am --signoff patches/0005-*.patch
git am --signoff patches/0006-*.patch

echo "Fusion de 'regex-email' dans 'tp6'"
git merge -m "Fusion de 'regex-email' dans 'tp6'" regex-email

echo "1 commit dans 'tp6'"
git am --signoff patches/0007-*.patch
