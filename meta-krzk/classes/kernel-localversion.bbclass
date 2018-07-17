# Bring back working LOCALVERSION_AUTO

do_preconfigure() {
    # Add GIT revision to the local version
    head=`git --git-dir=${S}/.git rev-parse --verify --short HEAD 2> /dev/null`
    printf "%s%s" -g $head > ${S}/.scmversion
}
addtask preconfigure before do_configure after do_unpack do_patch
