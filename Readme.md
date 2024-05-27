# Yocyo-raspi

Simple, minimal example on building <custom> raspberrypi5 images.

## Usage

1. Open folder in container.
2. Add this layer in bitbake.
3. Select add `MACHINE ?= "raspberrypi5"`
4. `bitbake core-image-base`
 - If problem downloading kernel occurs, look into the log for the
 git command and simply run it from a terminal manually.

## Config

Add to `bblayers.conf`:

- `IMAGE_INSTALL:append = " hellocmake cmake bash"`

Add to `local.conf`

- `IMAGE_ROOTFS_EXTRA_SPACE:append = " + 8000000"`

## Image
- Fix /etc/resolv.conf


### DNF example
[MyRepo]
name=My Repository
baseurl=http://mirror.transip.net/fedora/fedora/releases/39/Server/x86_64/os/
enabled=1
gpgcheck=0