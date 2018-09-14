#!/usr/bin/bash

git am --signoff patches/0001-*.patch
git am --signoff patches/0002-*.patch
git branch -D email-regex
git checkout -b email-regex
git am --signoff patches/0003-*.patch
git checkout tp6
git am --signoff patches/0004-*.patch
git am --signoff patches/0005-*.patch
git am --signoff patches/0006-*.patch
git am --signoff patches/0007-*.patch
