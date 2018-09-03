if [ -f ~/.bashrc ];
then
    . ~/.bashrc;
fi


if [ -f ~/.bash_aliases ];
then
    . ~/.bash_aliases
fi

export GIT_PS1_SHOWDIRTYSTATE=1
export GIT_PS1_SHOWSTASHSTATE=1
export GIT_PS1_SHOWUNTRACKEDFILES=1
export GIT_PS1_SHOWUPSTREAM=verbose
export GIT_PS1_DESCRIBE_STYLE=branch

export PS1="\[\033[38;5;208m\]" # orange
PS1="$PS1""[\t]"                                # time
PS1="$PS1""\[\033[38;5;28m\]"   # green
PS1="$PS1"" \u"                                 # user

if test -z "$WINELOADERNOEXEC"
then
        GIT_EXEC_PATH="$(git --exec-path 2>/dev/null)"
        COMPLETION_PATH="${GIT_EXEC_PATH%/libexec/git-core}"
        COMPLETION_PATH="${COMPLETION_PATH%/lib/git-core}"
        COMPLETION_PATH="$COMPLETION_PATH/share/git/completion"
        if test -f "$COMPLETION_PATH/git-prompt.sh"
        then
                . "$COMPLETION_PATH/git-completion.bash"
                . "$COMPLETION_PATH/git-prompt.sh"
#                PS1="$PS1""\[\e[35m\]"  # white
                PS1="$PS1"'`__git_ps1`'   # bash function
        fi
fi

PS1="$PS1""\[\033[38;5;12m\]"   # blue
PS1="$PS1"" \w"                                 # name of working directory
PS1="$PS1""\[\033[38;5;196m\]"  # red
PS1="$PS1""\n> "                                # newline >
PS1="$PS1""\[\033[38;5;15m\]"   # white