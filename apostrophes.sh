#!/usr/bin/bash

sed -i -E "s/([a-zA-Z])'([a-zA-ZàâäéèêëïîôöùûüÿæœÀÂÄÇÉÈÊËÎÏÔÖÙÛÜŸÆŒ])/\1’\2/" README.md docs/diaporama/chapitre-*.md
unix2dos README.md docs/diaporama/chapitre-*.md
