package DesignPatterns.Build;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/4/13 17:35
 * Email:  369013520@qq.com
 */

public class HotDryNoodlesWithBuilder {

    private boolean addShallot;
    private boolean addParsley;
    private boolean addChili;
    private boolean addSauerkraut;

    public HotDryNoodlesWithBuilder(Builder builder) {
        this.addShallot = builder.addShallot;
        this.addParsley = builder.addParsley;
        this.addChili = builder.addChili;
        this.addSauerkraut = builder.addSauerkraut;
    }

    public static class Builder {
        private boolean addShallot;
        private boolean addParsley;
        private boolean addChili;
        private boolean addSauerkraut;

        public Builder() {
        }

        public Builder withShallot() {
            this.addShallot = true;
            return this;
        }

        public Builder withParsley() {
            this.addShallot = true;
            return this;
        }

        public Builder withChili() {
            this.addShallot = true;
            return this;
        }

        public Builder withSauerkraut() {
            this.addShallot = true;
            return this;
        }

        public HotDryNoodlesWithBuilder build() {
            return new HotDryNoodlesWithBuilder(this);
        }
    }
}
