FROM ubuntu:noble

ARG DEBIAN_FRONTEND=noninteractive
ARG YOCTO_BRANCH=kirkstone

# build tools
RUN apt-get update && apt-get install -y gawk wget git diffstat \
unzip texinfo gcc build-essential chrpath \
socat cpio python3 python3-pip python3-pexpect \
xz-utils debianutils iputils-ping python3-git \
python3-jinja2 libegl1-mesa-dev libsdl1.2-dev \
python3-subunit mesa-common-dev zstd \
liblz4-tool file locales libacl1 sudo vim tmux

RUN locale-gen en_US.UTF-8

RUN useradd -ms /bin/bash builduser -g root -G sudo && echo "builduser:password" | chpasswd

RUN mkdir /yocto && chown builduser /yocto && \
    mkdir /yocto/build && chown builduser /yocto/build

USER builduser 
RUN cd /yocto && git clone -b ${YOCTO_BRANCH} https://git.yoctoproject.org/poky && \
    git clone -b ${YOCTO_BRANCH} https://git.yoctoproject.org/meta-raspberrypi && \
    git clone -b ${YOCTO_BRANCH} https://github.com/OE4T/meta-tegra.git