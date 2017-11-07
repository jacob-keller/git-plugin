package hudson.plugins.git;

import java.io.Serializable;
import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;

/**
 * Options for the {@link hudson.plugins.git.extensions.impl.ChangelogToBranch} extension.
 *
 * @deprecated
 * Replaced by ChangelogToRev
 *
 * @author <a href="mailto:dirk.reske@t-systems.com">Dirk Reske (dirk.reske@t-systems.com)</a>
 */
@Deprecated
public class ChangelogToBranchOptions extends AbstractDescribableImpl<ChangelogToBranchOptions> implements ChangelogOptions, Serializable {
    private String compareRemote;
    private String compareTarget;

    @DataBoundConstructor
    public ChangelogToBranchOptions(String compareRemote, String compareTarget) {
        this.compareRemote = compareRemote;
        this.compareTarget = compareTarget;
    }

    public ChangelogToBranchOptions(ChangelogToBranchOptions options) {
        this(options.getCompareRemote(), options.getCompareTarget());
    }

    public String getCompareRemote() {
        return compareRemote;
    }

    public String getCompareTarget() {
        return compareTarget;
    }

    public String getRef() {
        return compareRemote + "/" + compareTarget;
    }

    public String getRevision() {
        return getRef();
    }

    @Extension
    public static class DescriptorImpl extends Descriptor<ChangelogToBranchOptions> {

        @Override
        public String getDisplayName() {
            return "Options for Changelog To Branch strategy";
        }
    }
}
